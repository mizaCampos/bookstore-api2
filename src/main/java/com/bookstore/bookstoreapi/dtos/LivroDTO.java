package com.bookstore.bookstoreapi.dtos;

import org.hibernate.validator.constraints.Length;

import com.bookstore.bookstoreapi.domain.Livro;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class LivroDTO {

    private Integer id;
    
    @NotEmpty(message = "Campo TITULO é requerido")
    @Length(min = 3, max = 50, message = "O campo TITULO deve ter entre 3 e 2.000.000 caracteres")
    private String titulo;

    public LivroDTO(Livro obj){
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }
    
}
