package com.bookstore.bookstoreapi.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.bookstore.bookstoreapi.domain.Categoria;
import com.bookstore.bookstoreapi.domain.Livro;
import com.bookstore.bookstoreapi.exceptions.ObjectNotFoundException;
import com.bookstore.bookstoreapi.repositories.LivroRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LivroService {

    private LivroRepository livroRepository;
    private CategoriaService categoriaService;

    public Livro findById(Integer id){
        Optional<Livro> obj = livroRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo: " + Livro.class.getName()));
    }

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public List<Livro>findAllByCategoria(Integer id_categoria){
       Categoria obj = categoriaService.findById(id_categoria);
       return obj.getLivros();
    }
}
