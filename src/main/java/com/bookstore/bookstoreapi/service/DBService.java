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
 
		Livro l1 = new Livro(null, "Clean code","Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Engenhanria de software","Louis V.", "Lorem ipsum", cat1);
		Livro l3 = new Livro(null, "The times Machine","H.G. Welss", "Lorem ipsum", cat2);
		Livro l4 = new Livro(null, "The war of the Wordls","H.G. WElls", "Lorem ipsum", cat2);
		Livro l5 = new Livro(null, "I, Robot","Isaac Asiimov", "Lorem ipsum", cat2);

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3));
    }
    


}
