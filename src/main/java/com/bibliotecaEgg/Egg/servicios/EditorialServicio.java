/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaEgg.Egg.servicios;

import com.bibliotecaEgg.Egg.Miexceptions.MiExceptions;
import com.bibliotecaEgg.Egg.entidades.Editorial;
import com.bibliotecaEgg.Egg.repositorio.EditorialRepositorio;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Windows 10
 */
@Service
public class EditorialServicio {
    
    
    @Autowired
    EditorialRepositorio editorialRespositorio;
    
    @Transactional
        public void crearEditorial (String nombre ) throws MiExceptions{
    
            Validando(nombre);
        Editorial editorial = new Editorial() ;
        editorial.setNombre(nombre);
      
editorialRespositorio.save(editorial);
  
    }
    
    public List<Editorial> listarEditoriales() {
        List <Editorial> Editoriales = new ArrayList();
        
        Editoriales = editorialRespositorio.findAll();
        
        return Editoriales;
}
    
       public void Validando ( String nombre) throws MiExceptions {
       if (nombre.isEmpty() || nombre == null) 
           throw new MiExceptions("El nombre de la editorial no puede ser nulo");
       
       
   
}
    
}

