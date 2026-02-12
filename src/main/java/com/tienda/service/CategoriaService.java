package com.tienda.service;

import com.tienda.domain.Categoria;
import com.tienda.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Transactional(readOnly=true) //Indica que este método solo lee datos, lo que optimiza el rendimiento y evita bloqueos en la base de datos.
    public List<Categoria> getCategorias(boolean activos){
        var lista = categoriaRepository.findAll();
        //Falta algo aca
        return lista;
    }
    
    //Se escriben los metodos de CRUD create, read, update, delete
    
    @Transactional(readOnly=true) //Indica que este método solo lee datos, lo que optimiza el rendimiento y evita bloqueos en la base de datos.
    public Categoria getCategoria(Categoria categoria){
        
        return categoriaRepository.findById(categoria.getIdCategoria()).orElse(null);
        
    }
    
    @Transactional
    public void delete(Categoria categoria){
        //elimina el registro que tiene el id o el obejeto pasado por parametro.
         categoriaRepository.delete(categoria);
        
    }
    
     @Transactional
    public void save(Categoria categoria){
        //si idCategoria esta vacio .... se inserta un registro
        //si idCategoria tiene algo ... se modifica ese registro .
        //basicamente funciona como un create y un update 
         categoriaRepository.save(categoria);
        
    }
}
