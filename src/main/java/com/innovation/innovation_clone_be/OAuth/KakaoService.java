package com.innovation.innovation_clone_be.OAuth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.innovation.innovation_clone_be.Error.Dto.ResponseDto;
import com.innovation.innovation_clone_be.Member.Dto.TokenDto;
import com.innovation.innovation_clone_be.Member.Entity.Member;
import com.innovation.innovation_clone_be.Member.Repository.MemberRepository;
import com.innovation.innovation_clone_be.Member.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class KakaoService {
    private final MemberRepository userRepository;
    private final TokenProvider jwtTokenProvider;

    @Value("${kakao.client-id}")
    private String KakaoClientId;

    @Value("${kakao.redirect-uri}")
    private String KakaoRedirectUri;

    public ResponseDto<?> kakaoLogin(String code, HttpServletResponse response) throws JsonProcessingException {
        // 1. "인가 코드"로 "액세스 토큰" 요청
        String accessToken = getAccessToken(code);

        // 2. 토큰으로 카카오 API 호출
        OauthUserDto kakaoUserInfo = getKakaoUserInfo(accessToken);

        // 3. 필요시에 회원가입
        Member kakaoUser = registerKakaoUserIfNeeded(kakaoUserInfo);

        TokenDto tokenDto = jwtTokenProvider.generateTokenDto(kakaoUser);

        response.addHeader("Access-Token", "Bearer " + tokenDto.getAccessToken());
        response.addHeader("Refresh-Token", tokenDto.getRefreshToken());

        OAuthResponseDto responseDto = new OAuthResponseDto(kakaoUser, tokenDto, accessToken);

        return ResponseDto.success(responseDto);
    }


    private String getAccessToken(String code) throws JsonProcessingException {
        // HTTP Header 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        // HTTP Body 생성
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "authorization_code");
        body.add("client_id", KakaoClientId);
        body.add("redirect_uri", KakaoRedirectUri);
        body.add("code", code);

        // HTTP 요청 보내기
        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest =
                new HttpEntity<>(body, headers);
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        // HTTP 응답 (JSON) -> 액세스 토큰 파싱
        String responseBody = response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseBody);
        return jsonNode.get("access_token").asText();
    }

    private OauthUserDto getKakaoUserInfo(String accessToken) throws JsonProcessingException {
        // HTTP Header 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        // HTTP 요청 보내기
        HttpEntity<MultiValueMap<String, String>> kakaoUserInfoRequest = new HttpEntity<>(headers);
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoUserInfoRequest,
                String.class
        );

        String responseBody = response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseBody);
        Long id = jsonNode.get("id").asLong();
        String nickname = jsonNode.get("properties")
                .get("nickname").asText();
        String email = jsonNode.get("kakao_account")
                .get("email").asText();

        System.out.println("카카오 사용자 정보: " + id + ", " + nickname + ", " + email);
        return new OauthUserDto(id, email, nickname);
    }

    private Member registerKakaoUserIfNeeded(OauthUserDto kakaoUserInfo) {
        // DB 에 중복된 Kakao Id 가 있는지 확인
        Long kakaoId = kakaoUserInfo.getId();
        String email = kakaoUserInfo.getEmail();
        Member kakaoUser = userRepository.findMemberByEmail(email);
        if (kakaoUser == null) {
            // 카카오 사용자 이메일과 동일한 이메일을 가진 회원이 있는지 확인
            String kakaoEmail = kakaoUserInfo.getEmail();
            Member sameEmailUser = userRepository.findMemberByEmail(kakaoEmail);
            if (sameEmailUser != null) {
                kakaoUser = sameEmailUser;
                // 기존 회원정보에 카카오 Id 추가
                kakaoUser.setId(kakaoId);
            } else {
                // 신규 회원가입
                String nickname = kakaoUserInfo.getNickname();

                // email: kakao email
                //String email = kakaoUserInfo.getEmail();

                kakaoUser = new Member(email, nickname);

                forceLogin(kakaoUser);
            }

            userRepository.save(kakaoUser);
        }
        return kakaoUser;
    }

    private void forceLogin(Member kakaoUser) {
        UserDetailsImpl userDetails = new UserDetailsImpl();
        userDetails.setAccount(kakaoUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public ResponseDto<?> logout(HttpServletRequest request) {
        String token = request.getHeader("kakaoToken");

        String reqURL = "https://kapi.kakao.com/v1/user/logout";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + token);

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String result = "";
            String line = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseDto.success("logout success");
    }
}
