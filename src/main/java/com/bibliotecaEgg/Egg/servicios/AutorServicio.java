/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaEgg.Egg.servicios;

import com.bibliotecaEgg.Egg.Miexceptions.MiExceptions;
import com.bibliotecaEgg.Egg.entidades.Autor;
import com.bibliotecaEgg.Egg.repositorio.AutorRepositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Windows 10
 */
@Service
public class AutorServicio {
    
    @Autowired
    AutorRepositorio autorRespositorio;
    
    @Transactional
        public void crearAutor (String nombre ) throws MiExceptions{
    
            Validando(nombre);
        Autor autor = new Autor() ;
        autor.setNombre(nombre);
      
autorRespositorio.save(autor);
  
    }
    
    public List<Autor> listarAurotes() {
        List <Autor> Autores = new ArrayList();
        
        Autores = autorRespositorio.findAll();
        
        return Autores;
    }
    
   public void Validando ( String nombre) throws MiExceptions {
       if (nombre.isEmpty() || nombre == null) {
           throw new MiExceptions("El nombre del Autor no puede ser nulo");
       }
       
   }
    
    
    
}
