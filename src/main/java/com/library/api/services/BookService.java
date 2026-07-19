package com.library.api.services;

import com.library.api.BusinessException;
import com.library.api.entities.Book;
import com.library.api.enums.BorrowingStatus;
import com.library.api.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public List<Book> findAll(){
        return repository.findAll();
    }

    public Book findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new BusinessException("Esse livro não foi encontrado. Id: " + id));
    }

    public List<Book> findByAuthorId(Long authorId){
        return repository.findByAuthorId(authorId);
    }

    public List<Book> findByTitle(String title){
        return repository.findByTitle(title);
    }

    public List<Book> findByCategoryId(Long category_Id){
        return repository.findByCategoryId(category_Id);
    }

    public List<Book>findByPublicationDateBetween(LocalDate publicationDate) {
        return repository.findByPublicationDateBetween(publicationDate);
    }



    public void delete(Long id){
        Book book = findById(id);
        if(book.getBorrowings().stream()
                .anyMatch(b -> b.getStatus() == BorrowingStatus.PENDING
                || b.getStatus() == BorrowingStatus.LATE)){
            throw  new BusinessException("Esse livro possui emprestimos em aberto!");
        }
        repository.deleteById(id);
    }

    public Book insert(Book book){
        if(repository.existByIsbn(book.getIsbn())){
            throw new BusinessException("O ISBN ja esta associado a outro livro. Verifique se digitou corretamente! se ele pertencer exclusivamente ao seu livro, entre em contato para tratarmos sobre.");
        }
        return repository.save(book);
    }

    public Book update(Long id, Book book){
        if(repository.existByIsbn(book.getIsbn())){
            throw new BusinessException("O ISBN ja esta associado a outro livro. Verifique se digitou corretamente! se ele pertencer exclusivamente ao seu livro, entre em contato para tratarmos sobre.");
        }
        Book entity = findById(id);
        entity.setAuthor_id(book.getAuthor_id());
        entity.setIsbn(book.getIsbn());
        entity.setTitle(book.getTitle());
        entity.setAuthor_id(book.getAuthor_id());
        entity.setPublicationDate(book.getPublicationDate());
        entity.setCategory_id(book.getCategory_id());
        return repository.save(entity);
    }



}
