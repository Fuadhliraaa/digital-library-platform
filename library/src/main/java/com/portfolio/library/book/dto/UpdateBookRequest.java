package com.portfolio.library.book.dto;

import java.util.Set;
import java.util.UUID;

public record UpdateBookRequest(
        String title,
        String isbn,
        Integer stock,
        Set<UUID> authorIds
) {}
