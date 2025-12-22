package com.portfolio.library.book.service;

import com.portfolio.library.author.dto.AuthorResponse;
import com.portfolio.library.author.repository.AuthorRepository;
import com.portfolio.library.book.dto.BookRequest;
import com.portfolio.library.book.dto.BookResponse;
import com.portfolio.library.author.entity.Author;
import com.portfolio.library.book.dto.UpdateBookRequest;
import com.portfolio.library.book.entity.Book;
import com.portfolio.library.book.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookResponse createBook(BookRequest bookRequest) {

        if (StringUtils.hasText(bookRequest.isbn())) {
            if (bookRepository.existsByIsbn(bookRequest.isbn())) {
                throw new RuntimeException("BOOK_ISBN_IS_EXIST");
            }
        }

        Book book = new Book();
        book.setIsbn(bookRequest.isbn());
        book.setStock(bookRequest.stock());
        book.setTitle(bookRequest.title());

        if (bookRequest.authorsId() != null && !bookRequest.authorsId().isEmpty()) {

            Set<Author> authors = new HashSet<>(authorRepository.findAllById(bookRequest.authorsId()));

            if (authors.size() != bookRequest.authorsId().size()) {
                throw new RuntimeException("Authors with ID " + bookRequest.authorsId() + " not found");
            }

            if (!authors.isEmpty()) {
                book.setAuthors(authors);
            }

        }

        Book saved = bookRepository.save(book);
        log.info("Book saved {}", saved.getId());

        return toResponse(saved);

    }

    @Transactional
    public BookResponse update(UUID bookId, UpdateBookRequest request) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("BOOK_NOT_FOUND"));

        // Update title
        if (request.title() != null) {
            book.setTitle(request.title());
        }

        // Update ISBN
        if (request.isbn() != null) {

            if (bookRepository.existsByIsbn(request.isbn())) {
                throw new RuntimeException("BOOK_ISBN_EXISTS");
            }

            book.setIsbn(request.isbn());
        }

        // Update stock
        if (request.stock() != null) {
            book.setStock(request.stock());
        }

        // Update authors (optional)
        if (request.authorIds() != null) {

            Set<Author> authors =
                    new HashSet<>(authorRepository.findAllById(request.authorIds()));

            book.setAuthors(authors);
        }

        return toResponse(book);
    }

    private BookResponse toResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getIsbn(),
                book.getStock(),
                book.getAuthors() == null ? Set.of() :
                        book.getAuthors().stream()
                                .map(a -> new AuthorResponse(a.getId(), a.getName()))
                                .collect(Collectors.toSet())
        );
    }

}
