package com.portfolio.library.book.entity;

import com.portfolio.library.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.SQLDelete;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE books SET deleted = true WHERE id = ?")
@Filter(name = "softDeleteFilter", condition = "deleted = :isDeleted")
public class Book extends BaseEntity {

    @Column(nullable = false)
    private String title;

    private String isbn;

    private Integer stock;

    private boolean deleted = false;

    @ManyToMany
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors;

}
