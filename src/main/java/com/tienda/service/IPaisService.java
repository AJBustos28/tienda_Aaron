package com.tienda.service;

import java.util.List;
import com.tienda.entity.Pais;
import com.tienda.entity.Persona;

public interface IPaisService{
    public List<Pais> listCountry();
    
    public List<Persona> getAllPersona();
    
}
