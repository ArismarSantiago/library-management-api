package com.library.api.repositories;

import com.library.api.entities.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository {
    List<Category> findByName(String name);
    boolean existByName(String name);
}
