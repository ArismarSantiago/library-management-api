package com.library.api.controllers;

import com.library.api.entities.Author;
import com.library.api.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService service;

    @GetMapping
    public ResponseEntity <List<Author>> findAll(@RequestBody Author author){
        List<Author> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Author> findById(@PathVariable Long id){
        Author author = service.findById(id);
        return ResponseEntity.ok().body(author);
    }

    @GetMapping("/name")
    public ResponseEntity <List<Author>> findByName(String name){
        List<Author> list = service.findByName(name);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/email")
    public ResponseEntity <Optional<Author>> findByEmail(String email){
        Optional<Author> author = service.findByEmail(email);
        return ResponseEntity.ok().body(author);
    }

    @PostMapping("/{id}")
    public ResponseEntity <Author> insert(@RequestBody Author author) {
        author = service.insert(author);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(author.getId())
                .toUri();
        return ResponseEntity.ok().body(author);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity <Author> update(@PathVariable Long id, @RequestBody Author author){
        author = service.update(id, author);
        return ResponseEntity.ok().body(author);
    }


}


