package com.bookstore.bookstoreapi.service;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.bookstore.bookstoreapi.domain.Categoria;
import com.bookstore.bookstoreapi.domain.Livro;
import com.bookstore.bookstoreapi.repositories.CategoriaRepository;
import com.bookstore.bookstoreapi.repositories.LivroRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DBService {

    private LivroRepository livroRepository;
	private CategoriaRepository categoriaRepository;

    @Bean
    public void instanciarBaseDeDados(){

        Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Engenharia da Informatica", "Livros de TI");
		Categoria cat3 = new Categoria(null, "Biologia", "Livros Quimica");

		Livro l1 = new Livro(null, "Clean code", "Robert Martin", cat1);
		Livro l2 = new Livro(null, "Clean code", "Robert Martin", cat2);
		Livro l3 = new Livro(null, "Clean code", "Robert Martin", cat3);

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3));
    }
    


}
