package com.doanvinh.test.application.service;

import com.doanvinh.test.api.dto.req.BookAddReq;
import com.doanvinh.test.api.dto.req.BookDelReq;
import com.doanvinh.test.api.dto.req.BookUpdateReq;
import com.doanvinh.test.api.dto.res.BookAddRes;
import com.doanvinh.test.api.dto.res.BookDelRes;
import com.doanvinh.test.api.dto.res.BookGetRes;
import com.doanvinh.test.api.dto.res.BookUpdateRes;
import com.doanvinh.test.infrastructure.dataobject.BookEntity;

import java.time.LocalDate;
import java.util.List;

public interface BookService {
    BookAddRes createBook(BookAddReq req);
    BookGetRes getBookById(Long id);
    List<BookDelRes> deleteBookByIds(BookDelReq req);
    List<BookGetRes> getAllBooks();
    BookUpdateRes updateBook(Long id, BookUpdateReq req);
    List<BookGetRes> searchBook(LocalDate publishedDate, String title, Double minPrice, Double maxPrice);
}
