package com.innovation.innovation_clone_be.Error.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    //로그인(토큰) 관련 오류
    NULL_TOKEN("NULL_TOKEN", "로그인이 필요합니다."),
    MEMBER_NOT_FOUND("MEMBER_NOT_FOUND", "해당하는 유저가 없습니다."),
    INVALID_MEMBER("INVALID_MEMBER", "유저 정보가 일치하지 않습니다."),

    //회원가입 관련 오류
    DUPLICATE_EMAIL("DUPLICATE_EMAIL", "이미 이메일이 사용중입니다."),

    //제품(Product) 관련 오류
    INVALID_PRODUCT("INVALID_PRODUCT", "해당하는 제품이 없습니다.");



    private final String code;
    private final String message;
}
