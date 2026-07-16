package com.library.api.repositories;

import jakarta.persistence.JoinColumn;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibraryUser {
    List<LibraryUser>findByName(String name);
    Optional<LibraryUser>findByEmail(String email);
    List<LibraryUser>findByPhone(String phone);
}
