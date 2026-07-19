package com.library.api.repositories;

import com.library.api.entities.Book;
import com.library.api.entities.Borrowing;
import com.library.api.enums.BorrowingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
    List<Borrowing>findByAuthorId(Long author_id);
    List<Borrowing>findByBookId(Long book_id);
    Optional<Borrowing>findByStatus(BorrowingStatus status);
    Optional<Borrowing>findByBorrowDateBetween(Instant start, Instant end);
    Optional<Borrowing>findByExpectedReturnDateBetween(
            Instant start,
            Instant end
    );


}
