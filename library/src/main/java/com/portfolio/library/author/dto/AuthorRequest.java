package com.portfolio.library.author.dto;

import jakarta.validation.constraints.NotNull;

public record AuthorRequest(
        @NotNull String name
) {
}
