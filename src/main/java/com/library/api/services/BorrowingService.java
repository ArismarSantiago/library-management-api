package com.library.api.services;

import com.library.api.entities.Borrowing;
import com.library.api.enums.BorrowingStatus;
import com.library.api.repositories.BorrowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowingService {

    @Autowired
    private BorrowingRepository repository;

    public List<Borrowing> findAll(){
        return repository.findAll();
    }

   public List<Borrowing> findByAuthorId(Long author_id){
        return repository.findByAuthorId(author_id);
    }
    List<Borrowing>findByBookId(Long book_id){
       return repository.findByBookId(book_id);
    }
    Optional<Borrowing> findByStatus(BorrowingStatus status){
        return repository.findByStatus(status);
    }
    Optional<Borrowing>findByBorrowDateBetween(Instant start, Instant end){
        return repository.findByBorrowDateBetween(start, end);
    }

}
