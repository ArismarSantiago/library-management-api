package com.library.api.repositories;

import com.library.api.entities.Book;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository {
    List<Book>findByTitle(String title);
    boolean findByAvailableTrue(Boolean available);
    List<Book> findByAuthorId(Long author_id);
    List<Book> findByCategoryId(Long Category_id);
    Optional<Book> existByIsbn(String isbn);
    List<Book> findByPublicationDateBetween(LocalDate publicationDate);

}
