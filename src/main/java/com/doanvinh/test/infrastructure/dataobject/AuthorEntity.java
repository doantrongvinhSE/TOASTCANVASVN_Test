package com.doanvinh.test.infrastructure.dataobject;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "authors")
public class AuthorEntity {
    @Id
    private Long id;

    private String name;

    private String nationality;

    @ManyToMany(mappedBy = "authors")
    @JsonBackReference
    private List<BookEntity> books;
}
