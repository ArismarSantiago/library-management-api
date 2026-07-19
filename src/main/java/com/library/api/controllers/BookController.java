package com.library.api.controllers;

import com.library.api.entities.Author;
import com.library.api.entities.Book;
import com.library.api.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService service;



    @GetMapping
    public ResponseEntity <List<Book>> findAll(){
        List<Book>list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Book> findById(@PathVariable Long id){
        Book book = service.findById(id);
        return ResponseEntity.ok().body(book);
    }

    @GetMapping("/authorId")
    public  ResponseEntity <List<Book>> findByAuthorId(@PathVariable Long authorId){
        List<Book> list = service.findByAuthorId(authorId);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/title")
    public ResponseEntity <List<Book>> findByTitle(@PathVariable String title){
        List<Book> list = service.findByTitle(title);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/categoryId")
    public ResponseEntity <List<Book>> findByCategoryId(@PathVariable Long categoryId){
        List<Book> list = service.findByCategoryId(categoryId);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("PublicationDate")
    public ResponseEntity<List<Book>>findByPublicationDateBetween(@PathVariable LocalDate publicationDate){
        List<Book> list = service.findByPublicationDateBetween(publicationDate);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Book> insert(@RequestBody Book book){
        book = service.insert(book);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(book.getId())
                .toUri();
        return ResponseEntity.ok().body(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity <Book> update(@PathVariable Long id, @RequestBody Book book){
        book = service.update(id, book);
        return ResponseEntity.ok().body(book);
    }

}
