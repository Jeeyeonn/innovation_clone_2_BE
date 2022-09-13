package com.innovation.innovation_clone_be.OAuth;

import com.innovation.innovation_clone_be.Member.Dto.TokenDto;
import com.innovation.innovation_clone_be.Member.Entity.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OAuthResponseDto {
    private String email;
    private String username;
    private String accessToken;
    private String refreshToken;

    public OAuthResponseDto(Member kakaoUser, TokenDto tokenDto) {
        this.email = kakaoUser.getEmail();
        this.username = kakaoUser.getUsername();
        this.accessToken = tokenDto.getAccessToken();
        this.refreshToken = tokenDto.getRefreshToken();
    }
}
