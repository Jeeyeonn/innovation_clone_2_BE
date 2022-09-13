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
    private int myCartNum;

    public static <T> ResponseDto<T> success(T data) {
        return new ResponseDto<>(true, data, null, -1);
    }

    public static <T> ResponseDto<T> success(T data, int num) {
        return new ResponseDto<>(true, data, null, num);
    }

    public static <T> ResponseDto<T> fail(ErrorCode error) {
        return new ResponseDto<>(false, null, error, -1);
    }
}