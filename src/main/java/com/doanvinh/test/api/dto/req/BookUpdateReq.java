package com.doanvinh.test.api.dto.req;


import jakarta.validation.constraints.Positive;
import lombok.Data;


import java.time.LocalDate;
import java.util.List;

@Data
public class BookUpdateReq {
    private String title;
    private List<Long> authorIds;
    private LocalDate publishedDate;
    private String isbn;
    @Positive
    private Double price;

}
