package com.bookstore.bookstoreapi;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookstore.bookstoreapi.domain.Categoria;
import com.bookstore.bookstoreapi.domain.Livro;
import com.bookstore.bookstoreapi.repositories.CategoriaRepository;
import com.bookstore.bookstoreapi.repositories.LivroRepository;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class BookstoreapiApplication implements CommandLineRunner{

	private LivroRepository livroRepository;
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreapiApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		
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
