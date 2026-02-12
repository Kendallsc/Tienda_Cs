package com.tienda.repository;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository; //Este import lo que hace permitirnos ejecutar sentencias sobre la BD sin necesitadad de escribir las sentencias por ejempo
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/*findAll() → Obtiene todas las categorías.
findById(Long id) → Busca una categoría por su ID.
save(Producto producto) → Guarda o actualiza una categoría.
deleteById(Long id) → Elimina una categoría por su ID.
count() → Cuenta cuántas categorías hay en la tabla.*/
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    //Consulta ampliada para recuperar los productos entre un rango de precio, ordenados por precio
    public List<Producto> findByPrecioBetweenOrderByPrecio(double precioInf, double precioSup);

    // Consulta JPQL para recuperar los productos entre un rango de precio, ordenados por precio
    @Query(value = "SELECT a FROM Producto a WHERE a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.precio")
    public List<Producto> consultaJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

    // Consulta SQL para recuperar los productos entre un rango de precio, ordenados por precio
    @Query(nativeQuery=true, value = "SELECT * FROM producto a WHERE a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.precio")
    public List<Producto> consultaSQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
    
    //Consulta ampliada para recuperar los productos con una cantidad de existencias en especifico
    public List<Producto> findByExistenciasBetweenOrderByExistencias(double existenciasInf, double existenciasSup); 
}
