package com.doanvinh.test.infrastructure.jpa;

import com.doanvinh.test.infrastructure.dataobject.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    boolean existsByIsbn(String isbn);

    @Query("SELECT b FROM BookEntity b WHERE " +
            "(:publishedDate IS NULL OR b.publishedDate >= :publishedDate) AND " +
            "(:title IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))) AND " +
            "(:minPrice IS NULL OR b.price >= :minPrice) AND " +
            "(:maxPrice IS NULL OR b.price <= :maxPrice)")
    List<BookEntity> searchBooks(
            @Param("publishedDate") LocalDate publishedDate,
            @Param("title") String title,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice
    );
}
