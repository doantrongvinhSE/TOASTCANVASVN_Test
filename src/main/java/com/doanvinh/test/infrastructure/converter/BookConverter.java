package com.doanvinh.test.infrastructure.converter;

import com.doanvinh.test.api.dto.res.BookAddRes;
import com.doanvinh.test.api.dto.res.BookDelRes;
import com.doanvinh.test.api.dto.res.BookGetRes;
import com.doanvinh.test.api.dto.res.BookUpdateRes;
import com.doanvinh.test.domain.Book;
import com.doanvinh.test.infrastructure.dataobject.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookConverter {
    BookConverter INSTANCE = Mappers.getMapper(BookConverter.class);

    BookEntity toEntity(Book domain);

    BookAddRes toAddRes(BookEntity entity);

    BookUpdateRes toUpdateRes(BookEntity entity);

    List<BookGetRes> toGetRes(List<BookEntity> entities);


    BookGetRes toGetRes(BookEntity entity);

    List<BookDelRes> toDelRes(List<BookEntity> entities);


}
