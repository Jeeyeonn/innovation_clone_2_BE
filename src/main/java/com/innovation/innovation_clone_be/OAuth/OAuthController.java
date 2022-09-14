package com.innovation.innovation_clone_be.OAuth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.innovation.innovation_clone_be.Error.Dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.innovation.innovation_clone_be.Error.Enum.ErrorCode.NOTFOUND_LOGIN_TYPE;

@RestController
@RequiredArgsConstructor
public class OAuthController {

    private final KakaoService kakaoService;

    @GetMapping("/api/oauth/kakao")
    public ResponseDto<?> callBackKakao(@RequestParam(name = "code") String code, HttpServletResponse response) throws JsonProcessingException {
        return kakaoService.kakaoLogin(code, response);
    }

    @GetMapping("/api/oauth/kakao/logout")
    public ResponseDto<?> logout(HttpServletRequest request){
        return kakaoService.logout(request);
    }

}
