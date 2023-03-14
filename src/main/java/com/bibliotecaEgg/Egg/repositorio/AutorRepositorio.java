/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaEgg.Egg.repositorio;

import com.bibliotecaEgg.Egg.entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Windows 10
 */
@Repository
public interface AutorRepositorio extends JpaRepository<Autor, String>{
    
    
}
