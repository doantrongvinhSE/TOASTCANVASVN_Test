package com.doanvinh.test.api.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.time.LocalDate;
import java.util.List;

@Data
public class BookAddReq {
    @NotBlank(message = "Title must not be empty!")
    private String title;

    @NotNull
    @Size(min = 1)
    private List<Long> authorIds;

    @NotNull
    private LocalDate publishedDate;

    @NotBlank
    private String isbn;

    @NotNull
    @Positive(message = "Price must be positive!")
    private Double price;

}
