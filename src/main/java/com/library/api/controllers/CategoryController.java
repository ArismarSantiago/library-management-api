package com.library.api.controllers;

import com.library.api.entities.Category;
import com.library.api.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity <List<Category>> findAll(){
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Category> findById(@PathVariable Long id){
        Category category = service.findById(id);
        return ResponseEntity.ok().body(category);
    }

    @GetMapping("/name")
    public ResponseEntity <List<Category>> findByName(@PathVariable String name){
        List<Category> list = service.findByName(name);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody Category category){
        category = service.insert(category);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(category.getId())
                .toUri();
        return ResponseEntity.ok().body(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity <Category> update(@PathVariable Long id, @RequestBody Category category){
        category = service.update(id, category);
        return ResponseEntity.ok().body(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
