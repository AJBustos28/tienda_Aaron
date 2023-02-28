package com.tienda.service;

import com.tienda.entity.Pais;
import com.tienda.entity.Persona;
import com.tienda.repository.PaisRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService implements IPaisService{
    @Autowired
    private PaisRepository paisRepository;
    
    @Override
    public List<Pais> listCountry(){
        return (List<Pais>)paisRepository.findAll();    }
    
    @Override
    public List<Persona>getAllPersona(){
        throw new UnsupportedOperationException("Not supported yet");
    }
    
}
