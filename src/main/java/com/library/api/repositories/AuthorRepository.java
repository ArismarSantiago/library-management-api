package com.library.api.repositories;

import com.library.api.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author>findByName(String name);
    Optional<Author> findByEmail(String email);
    boolean existByEmail(String email);
}
