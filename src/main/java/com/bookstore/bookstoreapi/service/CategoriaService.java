package com.bookstore.bookstoreapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstoreapi.domain.Categoria;
import com.bookstore.bookstoreapi.dtos.CategoriaDTO;
import com.bookstore.bookstoreapi.exceptions.ObjectNotFoundException;
import com.bookstore.bookstoreapi.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria findById(Long id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria create(Categoria obj){
        obj.setId(null);
        return categoriaRepository.save(obj);
    }
    
}
