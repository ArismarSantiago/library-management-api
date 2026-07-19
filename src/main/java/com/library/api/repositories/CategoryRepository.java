package com.library.api.repositories;

import com.library.api.entities.Book;
import com.library.api.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByName(String name);
    boolean existByName(String name);
}
