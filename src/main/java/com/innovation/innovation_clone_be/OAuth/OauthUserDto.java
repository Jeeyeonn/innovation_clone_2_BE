package com.innovation.innovation_clone_be.OAuth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OauthUserDto {
    private Long id;
    private String email;
    private String nickname;
}