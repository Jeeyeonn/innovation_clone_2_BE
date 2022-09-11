package com.innovation.innovation_clone_be.Error.Dto;

import com.innovation.innovation_clone_be.Error.Enum.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseDto<T> {
    private boolean isSuccess;
    private T data;
    private ErrorCode error;

    public static <T> ResponseDto<T> success(T data) {
        return new ResponseDto<>(true, data, null);
    }

    public static <T> ResponseDto<T> fail(ErrorCode error) {
        return new ResponseDto<>(false, null, error);
    }
}