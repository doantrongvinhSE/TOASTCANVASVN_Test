package com.doanvinh.test.domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Book {
    private Long id;
    private String title;
    private LocalDate publishedDate;
    private String isbn;
    private Double price;
    private List<Long> authorIds;
}
