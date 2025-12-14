package com.portfolio.library.book.entity;

import com.portfolio.library.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

}
