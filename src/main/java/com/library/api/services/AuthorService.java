package com.library.api.services;

import com.library.api.BusinessException;
import com.library.api.entities.Author;
import com.library.api.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository repository;

    public List<Author> findAll(){
        return repository.findAll();
    }

    public List<Author>findByName(String name){
        return repository.findByName(name);
    }
    public Optional<Author> findByEmail(String email){
        if(repository.existByEmail(email)){
            throw new RuntimeException("Esse email ja se encontra cadastrado!");
        }
        return repository.findByEmail(email);
    }

    public Author findById(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new BusinessException("Id não correponde a nenhum autor. Id: " + id));
    }

    public void delete(Long id){
        Author author = findById(id);
        if(!author.getBooks().isEmpty()){
            throw new BusinessException("Esse autor contem livros cadastrados," +
                    " exclua os livros antes de excluir o autor!");
        }
        repository.deleteById(id);
    }

    public Author update(Long id, Author author){
        Author entity = findById(id);

        entity.setName(author.getName());
        entity.setEmail(author.getEmail());
        entity.setBiography(author.getBiography());

        return repository.save(entity);
    }

    public Author insert(Author author){
        if (repository.existByEmail(author.getEmail())){
            throw new BusinessException("Esse email ja se encontra em uso!");
        }
        return repository.save(author);
    }
    
}
