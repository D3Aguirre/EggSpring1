/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaEgg.Egg.repositorio;

import com.bibliotecaEgg.Egg.entidades.Libro;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Windows 10
 */

@Repository
public interface LibroRepositorio  extends JpaRepository<Libro, Long> {
    
    @Query ("SELECT l FROM LIBRO l WHERE l.LIBRO= : titulo")
    public Libro buscarLibroPorTitulo (@Param ("titulo") String titulo);
    
    @Query ( "SELECT l FROM LIBRO l WHERE l.AUTOR.NOMBRE= : nombre")
    public List<Libro> buscarPorAutor (@Param ("nombre") String nombre);
}
