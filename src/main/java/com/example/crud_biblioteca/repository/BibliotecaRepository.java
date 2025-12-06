package com.example.crud_biblioteca.repository;

import com.example.crud_biblioteca.model.BibliotecaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BibliotecaRepository extends JpaRepository<BibliotecaModel, Integer> {
    
}
