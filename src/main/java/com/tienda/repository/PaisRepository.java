package com.tienda.repository;
import com.tienda.entity.Pais;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author aaron
 */
@Repository
public interface PaisRepository extends CrudRepository<Pais, Long> {
    
}
