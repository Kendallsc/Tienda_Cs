package com.tienda.repository;

import com.tienda.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository; //Este import lo que hace permitirnos ejecutar sentencias sobre la BD sin necesitadad de escribir las sentencias por ejempo
/*findAll() → Obtiene todas las categorías.
findById(Long id) → Busca una categoría por su ID.
save(Categoria categoria) → Guarda o actualiza una categoría.
deleteById(Long id) → Elimina una categoría por su ID.
count() → Cuenta cuántas categorías hay en la tabla.*/


public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
