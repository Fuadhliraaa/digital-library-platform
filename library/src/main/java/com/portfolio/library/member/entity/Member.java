package com.portfolio.library.member.entity;

import com.portfolio.library.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "members")
@Entity
public class Member extends BaseEntity {

    @Column(nullable = false)
    private String email;

    private String name;

    private boolean isActive = true;

}
