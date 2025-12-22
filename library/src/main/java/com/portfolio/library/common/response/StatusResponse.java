package com.portfolio.library.common.response;

public record StatusResponse(
        int statusCode,
        String statusDesc
) {
}
