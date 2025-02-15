package com.doanvinh.test.application.service.impl;

import com.doanvinh.test.api.dto.req.BookAddReq;
import com.doanvinh.test.api.dto.req.BookDelReq;
import com.doanvinh.test.api.dto.req.BookUpdateReq;
import com.doanvinh.test.api.dto.res.BookAddRes;
import com.doanvinh.test.api.dto.res.BookDelRes;
import com.doanvinh.test.api.dto.res.BookGetRes;
import com.doanvinh.test.api.dto.res.BookUpdateRes;
import com.doanvinh.test.application.assembler.BookAssembler;
import com.doanvinh.test.application.service.BookService;
import com.doanvinh.test.common.constants.ErrorMessages;
import com.doanvinh.test.common.exception.BaseException;
import com.doanvinh.test.domain.Book;
import com.doanvinh.test.infrastructure.converter.BookConverter;
import com.doanvinh.test.infrastructure.dataobject.AuthorEntity;
import com.doanvinh.test.infrastructure.dataobject.BookEntity;
import com.doanvinh.test.infrastructure.jpa.AuthorRepository;
import com.doanvinh.test.infrastructure.jpa.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookAssembler bookAssembler;
    private final BookConverter bookConverter;

    @Override
    public BookAddRes createBook(BookAddReq req) {
        Book book = bookAssembler.toDomain(req);

        if (bookRepository.existsByIsbn(book.getIsbn())) {
            throw new BaseException(ErrorMessages.ISBN_EXITS);
        }

        List<AuthorEntity> authors = authorRepository.findAllById(book.getAuthorIds());

        if (authors.size() != book.getAuthorIds().size()) {
            throw new BaseException(ErrorMessages.AUTHOR_NOT_FOUND);
        }

        BookEntity savedBook = bookConverter.toEntity(book);
        savedBook.setAuthors(authors);

        bookRepository.save(savedBook);

        return bookConverter.toAddRes(savedBook);
    }

    @Override
    public BookGetRes getBookById(Long id) {
        BookEntity entity = bookRepository.findById(id).orElseThrow(() -> new BaseException(ErrorMessages.BOOK_NOT_FOUND));

        return bookConverter.toGetRes(entity);
    }

    @Override
    public List<BookDelRes> deleteBookByIds(BookDelReq req) {

        if (req.getIds() == null || req.getIds().isEmpty()) {
            throw new BaseException(ErrorMessages.REQUEST_INVALID);
        }

        List<BookEntity> books = bookRepository.findAllById(req.getIds());

        if (books.size() != req.getIds().size()) {
            throw new BaseException(ErrorMessages.BOOK_NOT_FOUND);
        }

        bookRepository.deleteAll(books);

        return bookConverter.toDelRes(books);
    }

    @Override
    public List<BookGetRes> getAllBooks() {
        List<BookEntity> books = bookRepository.findAll();
        return bookConverter.toGetRes(books);
    }

    @Override
    @Transactional
    public BookUpdateRes updateBook(Long id, BookUpdateReq req) {
        BookEntity bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new BaseException(ErrorMessages.BOOK_NOT_FOUND));


        log.info(String.valueOf(req));

        if (req.getTitle() != null) {
            bookEntity.setTitle(req.getTitle());
        }

        if (req.getAuthorIds() != null && !req.getAuthorIds().isEmpty()) {
            List<AuthorEntity> authors = authorRepository.findAllById(req.getAuthorIds());
            if (authors.size() != req.getAuthorIds().size()) {
                throw new BaseException(ErrorMessages.AUTHOR_NOT_FOUND);
            }
            bookEntity.setAuthors(authors);
        }

        if (req.getPublishedDate() != null) {
            bookEntity.setPublishedDate(req.getPublishedDate());
        }

        if (req.getIsbn() != null) {
            if (bookRepository.existsByIsbn(req.getIsbn())) {
                throw new BaseException(ErrorMessages.ISBN_EXITS);
            }
            bookEntity.setIsbn(req.getIsbn());
        }

        if (req.getPrice() != null) {
            bookEntity.setPrice(req.getPrice());
        }

        log.info(String.valueOf(bookEntity));

        bookRepository.save(bookEntity);

        return bookConverter.toUpdateRes(bookEntity);
    }

    @Override
    public List<BookGetRes> searchBook(LocalDate publishedDate, String title, Double minPrice, Double maxPrice) {
        List<BookEntity> entities = bookRepository.searchBooks(publishedDate, title, minPrice, maxPrice);
        return bookConverter.toGetRes(entities);
    }


}
