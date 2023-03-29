package com.tienda.service;

import com.tienda.entity.Persona;
import com.tienda.repository.PersonaRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    private PersonaRepository personaRepository;
    
    @Override
    public List<Persona> getAllPersona(){
        return(List<Persona>)personaRepository.findAll();   
    }
    @Override
    public Persona getPersonaById(long id){
        return personaRepository.findById(id).orElse(null);
    }
    @Override
    public void savePersona(Persona persona){
        personaRepository.save(persona);
    }
    @Override
    public void delete(long id){
        personaRepository.deleteById(id);
    }
    @Override
    public Persona findByNombre(String username) {
        return personaRepository.findByNombre(username);
    }

    @Override
    public Persona findbyNombre(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
