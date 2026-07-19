package com.library.api.repositories;

import com.library.api.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    List<Book>findByTitle(String title);
    boolean findByAvailableTrue(Boolean available);
    List<Book> findByAuthorId(Long author_id);
    List<Book> findByCategoryId(Long Category_id);
    Boolean existByIsbn(String isbn);
    List<Book> findByPublicationDateBetween(LocalDate publicationDate);

}
