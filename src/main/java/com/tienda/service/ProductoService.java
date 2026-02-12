package com.tienda.service;

import com.tienda.domain.Producto;
import com.tienda.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Transactional(readOnly = true) //Indica que este método solo lee datos, lo que optimiza el rendimiento y evita bloqueos en la base de datos.
    public List<Producto> getProductos(boolean activos) {
        var lista = productoRepository.findAll();
        //Falta algo aca
        return lista;
    }

    //Se escriben los metodos de CRUD create, read, update, delete
    @Transactional(readOnly = true) //Indica que este método solo lee datos, lo que optimiza el rendimiento y evita bloqueos en la base de datos.
    public Producto getProducto(Producto producto) {

        return productoRepository.findById(producto.getIdProducto()).orElse(null);

    }

    @Transactional
    public void delete(Producto producto) {
        //elimina el registro que tiene el id o el obejeto pasado por parametro.
        productoRepository.delete(producto);

    }

    @Transactional
    public void save(Producto producto) {
        //si idProducto esta vacio .... se inserta un registro
        //si idProducto tiene algo ... se modifica ese registro .
        //basicamente funciona como un create y un update 
        productoRepository.save(producto);

    }

    @Transactional(readOnly = true) //Indica que este método solo lee datos, lo que optimiza el rendimiento y evita bloqueos en la base de datos.
    public List<Producto> consultaAmpliada(double precioInf, double precioSup) {
        return productoRepository.findByPrecioBetweenOrderByPrecio(precioInf, precioSup);
    }

    @Transactional(readOnly = true) //Indica que este método solo lee datos, lo que optimiza el rendimiento y evita bloqueos en la base de datos.
    public List<Producto> consultaJPQL(double precioInf, double precioSup) {
        return productoRepository.consultaJPQL(precioInf, precioSup);
    }

    @Transactional(readOnly = true) //Indica que este método solo lee datos, lo que optimiza el rendimiento y evita bloqueos en la base de datos.
    public List<Producto> consultaSQL(double precioInf, double precioSup) {
        return productoRepository.consultaSQL(precioInf, precioSup);
    }
    
    @Transactional(readOnly = true) //Indica que este método solo lee datos, lo que optimiza el rendimiento y evita bloqueos en la base de datos.
    public List<Producto> consultaAmpliadaExistencias(double existenciasInf, double existenciasSup) {
        return productoRepository.findByExistenciasBetweenOrderByExistencias(existenciasInf, existenciasSup);
    }

}
