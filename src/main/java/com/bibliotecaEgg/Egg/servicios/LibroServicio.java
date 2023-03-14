/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaEgg.Egg.servicios;

import com.bibliotecaEgg.Egg.Miexceptions.MiExceptions;
import com.bibliotecaEgg.Egg.entidades.Autor;
import com.bibliotecaEgg.Egg.entidades.Editorial;
import com.bibliotecaEgg.Egg.entidades.Libro;
import com.bibliotecaEgg.Egg.repositorio.AutorRepositorio;
import com.bibliotecaEgg.Egg.repositorio.EditorialRepositorio;
import com.bibliotecaEgg.Egg.repositorio.LibroRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Windows 10
 */


@Service
public class LibroServicio {
    
@Autowired
    private LibroRepositorio libroRepositorio; 

@Autowired
private AutorRepositorio autorRepositorio;

@Autowired
private EditorialRepositorio editorialRepositorio;

@Transactional
// todos metodos que hagan modificaciones permanentes deben tener esta anotacion
    public void crearLibro (Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial ) throws MiExceptions{
    
        Validando(isbn, titulo, ejemplares, idAutor, idEditorial);
        
        Libro libro = new Libro() ;
       libro.setIsbn(isbn);
       libro.setTitulo(titulo);
       libro.setEjemplares(ejemplares);
       
       libro.setFechaalta(new Date());
       //para instanciar fecha actual al momento de carga

       libroRepositorio.save(libro);
        
        
    }
    
    public List<Libro> listarLibros() {
        List <Libro> Libros = new ArrayList();
        
        Libros = libroRepositorio.findAll();
        
        return Libros;
    }
    
    public void modificarLibro (Long isbn, String titulo, String idAutor, String idEditorial ) throws MiExceptions{
        
        Validando(isbn, titulo, Integer.BYTES, idAutor, idEditorial);
        
        Optional <Libro> respuesta = libroRepositorio.findById(isbn);
        Optional <Autor> respuestaAutor = autorRepositorio.findById(idAutor);
        Optional <Editorial> respuestaEditorial = editorialRepositorio.findById(idAutor);
        
        if (respuesta.isPresent()) {
            Libro libro = respuesta.get();
            libro.setTitulo(titulo);
            
        }
    }
    
    public void Validando (Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiExceptions {
        
        if (isbn == null) {
            throw new MiExceptions ("Isbn no puede ser nulo");
        }
         if (titulo.isEmpty() || isbn == null) {
            throw new MiExceptions ("Titulo no puede ser nulo");
        }
        
         if (ejemplares == null) {
            throw new MiExceptions ("Ejemplares no puede ser nulo");
         }
             if (idAutor == null) {
            throw new MiExceptions ("idAutor no puede ser nulo");
            
             }
            
                if (idEditorial == null) {
            throw new MiExceptions ("idAutor no puede ser nulo");
            
             }
    }
}
