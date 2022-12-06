package com.bookstore.bookstoreapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstoreapi.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    
}