package com.factoriaf5.firstspring.firstspring.controllers;

import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.factoriaf5.firstspring.firstspring.models.Contacto;
import com.factoriaf5.firstspring.firstspring.services.ContactoService;

public class ContactoController {
    @Autowired // Inyección de dependencia
    ContactoService contactoService;

    @GetMapping(value="/contacto")
    public List<Contacto> getAll() {
        return contactoService.getAll();
    }

    @PostMapping(value="/contacto")
    public Contacto store(@RequestBody Contacto newContacto) {
        return contactoService.store(newContacto);
    }

    @DeleteMapping(path = "/contacto/{id}")
    public Map<String,String> deleteLetter(@PathVariable Long id) {
        return contactoService.delete(id);
    }

    @PutMapping(path = "/contacto/{id}")
    public Contacto updateLetter(@PathVariable Long id, @RequestBody Contacto contacto) {
        return contactoService.update(id,contacto);
    }





    
    
  
}
