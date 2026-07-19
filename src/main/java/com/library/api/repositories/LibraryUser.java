package com.library.api.repositories;

import com.library.api.entities.Book;
import jakarta.persistence.JoinColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibraryUser extends JpaRepository<LibraryUser, Long> {
    List<LibraryUser>findByName(String name);
    Optional<LibraryUser>findByEmail(String email);
    List<LibraryUser>findByPhone(String phone);
}
