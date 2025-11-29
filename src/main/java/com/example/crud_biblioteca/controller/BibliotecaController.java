package com.example.crud_biblioteca.controller;

import com.example.crud_biblioteca.model.BibliotecaModel;
import com.example.crud_biblioteca.repository.BibliotecaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livro")
@AllArgsConstructor
public class BibliotecaController {
    private final BibliotecaRepository bibliotecaRepository;

    @GetMapping
    public List<BibliotecaModel> getAllLivros() {
        return bibliotecaRepository.findAll();
    }

    @PostMapping("/create")
    public BibliotecaModel createLivro(@RequestBody BibliotecaModel livro) {
        return bibliotecaRepository.save(livro);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<BibliotecaModel> getLivroById(@PathVariable Integer id) {
        return bibliotecaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<BibliotecaModel> getLivroByTitulo(@PathVariable String titulo) {
        return bibliotecaRepository.findByTitulo(titulo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<BibliotecaModel> getLivroByAutor(@PathVariable String autor) {
        return bibliotecaRepository.findByAutor(autor)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BibliotecaModel> getLivroByIsbn(@PathVariable String isbn) {
        return bibliotecaRepository.findByIsbn(isbn)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/ano/{anoPublicacao}")
    public ResponseEntity<BibliotecaModel> getLivroByAnoPublicacao(@PathVariable String anoPublicacao) {
        return bibliotecaRepository.findByAnoPublicacao(anoPublicacao)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<BibliotecaModel> updateLivro(@PathVariable Integer id, @RequestBody BibliotecaModel livro) {
        return bibliotecaRepository.findById(id)
                .map(bibliotecaModel -> {
                    if (livro.getTitulo() != null) {
                        bibliotecaModel.setTitulo(livro.getTitulo());
                    }
                    if (livro.getAutor() != null) {
                        bibliotecaModel.setAutor(livro.getAutor());
                    }
                    if (livro.getIsbn() != null) {
                        bibliotecaModel.setIsbn(livro.getIsbn());
                    }
                    if (livro.getAnoPublicacao() != null) {
                        bibliotecaModel.setAnoPublicacao(livro.getAnoPublicacao());
                    }
                    if (livro.getDisponivel() != null) {
                        bibliotecaModel.setDisponivel(livro.getDisponivel());
                    }
                    BibliotecaModel updatedLivro = bibliotecaRepository.save(bibliotecaModel);
                    return ResponseEntity.ok(updatedLivro);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLivro(@PathVariable Integer id) {
        if(bibliotecaRepository.existsById(id)) {
            bibliotecaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}