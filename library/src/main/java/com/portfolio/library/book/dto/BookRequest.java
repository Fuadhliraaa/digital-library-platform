package com.portfolio.library.book.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;
import java.util.UUID;

public record BookRequest(
        @NotBlank String title,
        String isbn,
        @NotNull Integer stock,
        Set<UUID> authorsId
) {
}
