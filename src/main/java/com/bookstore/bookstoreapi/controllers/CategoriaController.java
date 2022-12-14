package com.bookstore.bookstoreapi.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookstore.bookstoreapi.domain.Categoria;
import com.bookstore.bookstoreapi.dtos.CategoriaDTO;

import com.bookstore.bookstoreapi.service.CategoriaService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/{id}")
    public ResponseEntity<Categoria>findById(@PathVariable Integer id){
        Categoria obj = categoriaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>>findAll(){
        List<Categoria> list = categoriaService.findAll();
        List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Categoria>create(@Valid @RequestBody CategoriaDTO categoriaDTO){

        var categoria = new Categoria();
        BeanUtils.copyProperties(categoriaDTO, categoria);
        categoriaService.create(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO>replace(@Valid @PathVariable Integer id, @RequestBody CategoriaDTO categoriaDTO){
        Categoria newObj = categoriaService.replace(id, categoriaDTO);
        return ResponseEntity.ok().body(new CategoriaDTO(newObj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable Integer id){
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
