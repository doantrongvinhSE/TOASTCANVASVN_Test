package com.doanvinh.test.application.assembler;

import com.doanvinh.test.api.dto.req.BookAddReq;
import com.doanvinh.test.common.utils.IdGenerator;
import com.doanvinh.test.domain.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class BookAssembler {
    public Book toDomain(BookAddReq req) {
        Book book = reqToDomain(req);
        book.setId(IdGenerator.INSTANCE.nextId());

        return book;
    }



    public abstract Book reqToDomain(BookAddReq req);

}
