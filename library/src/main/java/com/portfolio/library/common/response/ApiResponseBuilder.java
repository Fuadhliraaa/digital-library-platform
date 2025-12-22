package com.portfolio.library.common.response;

public class ApiResponseBuilder {
    public static <T> ApiResponse<DataResponse<T>> success(T data) {
        return new ApiResponse<>(
                new StatusResponse(200, "OK"),
                new DataResponse<>(data)
        );
    }

    public static ApiResponse<Void> success() {
        return new ApiResponse<>(
                new StatusResponse(200, "OK"),
                null
        );
    }

    public static ApiResponse<Void> error(int code, String message) {
        return new ApiResponse<>(
                new StatusResponse(code, message),
                null
        );
    }
}
