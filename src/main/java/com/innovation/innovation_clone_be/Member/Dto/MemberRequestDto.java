package com.innovation.innovation_clone_be.Member.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequestDto {

    @NotBlank
    @Email(message = "Email 형식에 맞춰주세요.")
    private String email;

    @Pattern(regexp = "[a-zA-Z1-9]{4,16}", message = "비밀번호는 영어와 숫자 포함해서 4~16자 사이로 입력해주세요.")
    @NotBlank
    private String password;

    @NotBlank
    private String username;

    @NotNull
    private Boolean subscription;

}
