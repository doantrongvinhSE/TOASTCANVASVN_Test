package com.doanvinh.test.api.dto.res;

import com.doanvinh.test.infrastructure.dataobject.AuthorEntity;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class BookUpdateRes {
    private Long id;
    private String title;
    private LocalDate publishedDate;
    private String isbn;
    private Double price;
    private List<AuthorEntity> authors;
}
