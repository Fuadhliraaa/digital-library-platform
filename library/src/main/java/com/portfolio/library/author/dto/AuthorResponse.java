package com.portfolio.library.author.dto;

import java.util.UUID;

public record AuthorResponse(
        UUID id,
        String name
) {
}
