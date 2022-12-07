package com.bookstore.bookstoreapi.dtos;

import com.bookstore.bookstoreapi.domain.Livro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class LivroDTO {

    private Integer id;
    private String titulo;

    public LivroDTO(Livro obj){
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }
    
}
