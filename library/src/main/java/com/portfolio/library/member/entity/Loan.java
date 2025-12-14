package com.portfolio.library.member.entity;

import com.portfolio.library.book.entity.Book;
import com.portfolio.library.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "loans")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    private Instant borrowedAt;
    private Instant returnedAt;

}
