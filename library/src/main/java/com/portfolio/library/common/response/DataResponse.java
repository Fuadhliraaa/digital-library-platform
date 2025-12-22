package com.portfolio.library.common.response;

public record DataResponse<T>(
        T object
) {
}
