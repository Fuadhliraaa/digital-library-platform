package com.portfolio.library.common.response;

public record ApiResponse<T>(
    StatusResponse status,
    T data
) {
}
