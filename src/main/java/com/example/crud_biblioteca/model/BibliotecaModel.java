package com.example.crud_biblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Livro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BibliotecaModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "isbn", unique = true, nullable = false)
    private String isbn;

    @Column(name = "anoPublicacao", nullable = false)
    private String anoPublicacao;

    @Column(name = "disponivel", nullable = false)
    private Boolean disponivel;
}