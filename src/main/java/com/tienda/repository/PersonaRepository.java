package com.tienda.repository;
import com.tienda.entity.Persona;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {
    Persona findByNombre (String username);
}
