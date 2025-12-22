package com.portfolio.library.book.dto;

import com.portfolio.library.author.dto.AuthorResponse;

import java.util.Set;
import java.util.UUID;

public record BookResponse(
        UUID id,
        String tittle,
        String isbn,
        Integer stock,
        Set<AuthorResponse> authors
) {
}
