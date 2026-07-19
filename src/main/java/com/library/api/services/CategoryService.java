package com.library.api.services;

import com.library.api.BusinessException;
import com.library.api.entities.Category;
import com.library.api.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    public List<Category> findAll(){
        return  repository.findAll();
    }

    public Category findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new BusinessException("Categoria não encontrada. Id: " + id));
    }

    public List<Category> findByName(String name){
        return  repository.findByName(name);
    }

    public Category insert(Category category){
        if(repository.existByName(category.getName())){
            throw new BusinessException("Essa categoria ja existe no sistema!");
        }
        return repository.save(category);
    }
    public void delete(Long id){
        Category existBooksInCategory = findById(id);
        if (!existBooksInCategory.getBooks().isEmpty()){
            throw  new BusinessException("Exclua os livros dessa mesma categoria antes de excluir a categoria!");
        }
        repository.deleteById(id);
    }

    public Category update(Long id, Category category){
        Category entity = findById(id);
        if(repository.existByName(category.getName())){
            throw new BusinessException("Essa categoria ja existe no sistema!");
        }
        entity.setName(category.getName());
        entity.setDescription(category.getDescription());
        return repository.save(entity);
    }
}
