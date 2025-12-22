package com.portfolio.library.book.controller;

import com.portfolio.library.book.dto.BookRequest;
import com.portfolio.library.book.dto.BookResponse;
import com.portfolio.library.book.dto.UpdateBookRequest;
import com.portfolio.library.book.service.BookService;
import com.portfolio.library.common.response.ApiResponse;
import com.portfolio.library.common.response.ApiResponseBuilder;
import com.portfolio.library.common.response.DataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<DataResponse<BookResponse>>> create(
            @RequestBody BookRequest bookRequest
    ) {
        BookResponse response = bookService.createBook(bookRequest);
        return ResponseEntity.ok(
                ApiResponseBuilder.success(response)
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<DataResponse<BookResponse>>> update(
            @PathVariable UUID id,
            @RequestBody UpdateBookRequest request
    ) {
        BookResponse response = bookService.update(id, request);
        return ResponseEntity.ok(
                ApiResponseBuilder.success(response)
        );
    }

}
