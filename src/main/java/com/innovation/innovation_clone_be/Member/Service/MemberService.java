package com.innovation.innovation_clone_be.Member.Service;

import antlr.Token;
import com.innovation.innovation_clone_be.Error.Dto.ResponseDto;
import com.innovation.innovation_clone_be.Error.Enum.ErrorCode;
import com.innovation.innovation_clone_be.Member.Dto.LoginRequestDto;
import com.innovation.innovation_clone_be.Member.Dto.MemberRequestDto;
import com.innovation.innovation_clone_be.Member.Dto.MemberResponseDto;
import com.innovation.innovation_clone_be.Member.Dto.TokenDto;
import com.innovation.innovation_clone_be.Member.Entity.Member;
import com.innovation.innovation_clone_be.Member.Repository.MemberRepository;
import com.innovation.innovation_clone_be.Member.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
@RequiredArgsConstructor
public class MemberService {


    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    @Transactional
    public ResponseDto<?> createMember(MemberRequestDto requestDto) {
        if (isPresentMember(requestDto.getEmail()) != null) {
            return ResponseDto.fail(ErrorCode.DUPLICATE_EMAIL);
        }

        String pw = passwordEncoder.encode(requestDto.getPassword());
        Member member = new Member(requestDto, pw);
        memberRepository.save(member);

        return ResponseDto.success("success signup");
    }

    @Transactional
    public ResponseDto<?> login(LoginRequestDto requestDto, HttpServletResponse response) {
        Member member = isPresentMember(requestDto.getEmail());
        if (member == null) {
            return ResponseDto.fail(ErrorCode.MEMBER_NOT_FOUND);
        }
        if (!member.validatePassword(passwordEncoder, requestDto.getPassword())) {
            return ResponseDto.fail(ErrorCode.INVALID_MEMBER);
        }
        TokenDto tokenDto = tokenProvider.generateTokenDto(member);
        tokenToHeaders(tokenDto, response);
        return ResponseDto.success("success login");

    }


    @Transactional(readOnly = true)
    public Member isPresentMember(String email) {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
        return optionalMember.orElse(null);
    }

    public void tokenToHeaders(TokenDto tokenDto, HttpServletResponse response) {
        response.addHeader("Authorization", "Bearer " + tokenDto.getAccessToken());
        response.addHeader("Refresh-Token", tokenDto.getRefreshToken());
    }
}
