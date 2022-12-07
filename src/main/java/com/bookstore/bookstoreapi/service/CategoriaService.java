package com.bookstore.bookstoreapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria create(Categoria obj){
        obj.setId(null);
        return categoriaRepository.save(obj);
    }

    public Categoria replace(Integer id, CategoriaDTO categoriaDTO) {
        Categoria obj = findById(id);
        obj.setNome(categoriaDTO.getNome());
        obj.setDescricao(categoriaDTO.getDescricao());
        return categoriaRepository.save(obj);
    }

    public void delete(Integer id) {
        try {
            findById(id);
            categoriaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new com.bookstore.bookstoreapi.exceptions.DataIntegrityViolationException("A categoria não pode ser deletada! Possui livros associados");
        }
    }

}
