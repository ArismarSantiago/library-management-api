package com.library.api.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class LibraryUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150)
    private String name;
    @Column(nullable = false, length = 150, unique = true)
    private String email;
    @Column(nullable = false, length = 20)
    private String phone;

    @ManyToOne
    @JsonBackReference
    private Borrowing borrowing;

    public LibraryUser() {
    }

    public LibraryUser(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }


    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (!(o instanceof LibraryUser that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
