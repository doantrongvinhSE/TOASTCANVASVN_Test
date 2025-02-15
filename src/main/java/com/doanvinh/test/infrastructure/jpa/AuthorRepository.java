package com.doanvinh.test.infrastructure.jpa;

import com.doanvinh.test.infrastructure.dataobject.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
    Optional<AuthorEntity> findAuthorEntitiesById(Long id);

    boolean existsById(Long id);
}
