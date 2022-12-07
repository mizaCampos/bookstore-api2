package com.bookstore.bookstoreapi.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bookstoreapi.domain.Livro;
import com.bookstore.bookstoreapi.dtos.LivroDTO;
import com.bookstore.bookstoreapi.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/{id}")
    public ResponseEntity<Livro>findById(@PathVariable Integer id){
        Livro obj = livroService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

    @GetMapping()
    public ResponseEntity<List<LivroDTO>> findAll(){
        List<Livro> list = livroService.findAll();
        List<LivroDTO>livroDTOs = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(livroDTOs);
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<LivroDTO>>findByCategoria(@RequestParam(value = "categoria", defaultValue = "0") Integer id_categoria){
        List<Livro>list = livroService.findAllByCategoria(id_categoria);
        List<LivroDTO>livroDTOs = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(livroDTOs);
    }
    
    //localhost:8080/livros?requestParam=1
}
