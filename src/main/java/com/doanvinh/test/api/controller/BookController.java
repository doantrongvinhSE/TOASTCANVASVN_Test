package com.doanvinh.test.api.controller;

import com.doanvinh.test.api.dto.req.BookAddReq;
import com.doanvinh.test.api.dto.req.BookDelReq;
import com.doanvinh.test.api.dto.req.BookUpdateReq;
import com.doanvinh.test.application.service.BookService;
import com.doanvinh.test.common.protocol.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
@Tag(name = "Book API", description = "APIs for managing book.")

public class BookController {
    private final BookService bookService;

    @GetMapping
    public BaseResponse<?> getAllBooks() {
        return BaseResponse.success(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public BaseResponse<?> createBook(@PathVariable("id") Long id) {
        return BaseResponse.success(bookService.getBookById(id));
    }

    @PostMapping
    public BaseResponse<?> createBook(@Validated @RequestBody BookAddReq req) {
        return BaseResponse.success(bookService.createBook(req));
    }

    @DeleteMapping
    public BaseResponse<?> deleteBookByIds(@Validated @RequestBody BookDelReq req) {
        return BaseResponse.success(bookService.deleteBookByIds(req));
    }

    @PutMapping("/{id}")
    public BaseResponse<?> updateBookById(@PathVariable("id") Long id, @Validated @RequestBody BookUpdateReq req) {
        return BaseResponse.success(bookService.updateBook(id, req));
    }

    @GetMapping("/search")
    public BaseResponse<?> searchBookByKeyword( @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate publishedDate,
                                                @RequestParam(required = false) String title,
                                                @RequestParam(required = false) Double minPrice,
                                                @RequestParam(required = false) Double maxPrice) {
        return BaseResponse.success(bookService.searchBook(publishedDate, title, minPrice, maxPrice));
    }


}
