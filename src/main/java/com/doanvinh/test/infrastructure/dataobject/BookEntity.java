package com.doanvinh.test.infrastructure.dataobject;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ManyToAny;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "books")
public class BookEntity {
    @Id
    private Long id;

    private String title;

    @Temporal(TemporalType.DATE)
    private LocalDate publishedDate;

    @Column(unique = true)
    private String isbn;

    private Double price;

    @ManyToMany
    @JoinTable(
            name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    @JsonManagedReference
    private List<AuthorEntity> authors;


}
