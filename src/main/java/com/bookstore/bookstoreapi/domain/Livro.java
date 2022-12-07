package com.bookstore.bookstoreapi.domain;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode

public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @EqualsAndHashCode.Exclude
    @NotEmpty(message = "Campo TITULO é requerido")
    @Length(min = 3, max = 50, message = "O campo TITULO deve ter entre 3 e 100 caracteres")
    private String titulo;

    @EqualsAndHashCode.Exclude
    @NotEmpty(message = "Campo TEXTO é requerido")
    @Length(min = 3, max = 2000000, message = "O campo TEXTO deve ter entre 3 e 2.000.000 caracteres")
    private String texto;

    @EqualsAndHashCode.Exclude
    @NotEmpty(message = "Campo NOME DO AUTOR é requerido")
    @Length(min = 3, max = 100, message = "O campo NOME DO AUTOR  deve ter entre 3 e 100 caracteres")
    private String nome_autor;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categorias;
    
}
