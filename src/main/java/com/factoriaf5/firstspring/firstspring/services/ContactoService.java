package com.factoriaf5.firstspring.firstspring.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factoriaf5.firstspring.firstspring.models.Contacto;
import com.factoriaf5.firstspring.firstspring.repositories.ContactoRepository;

@Service
public class ContactoService {
    
    @Autowired
    ContactoRepository repository;

    public List<Contacto> getAll() {
        return repository.findAll();
    }

    public Contacto store(Contacto newContacto) {
        return repository.save(newContacto);
    }

    public Map<String,String> delete(Long id) {
        Map<String,String> message = new HashMap<>();

        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            message.put("message", "OK");
            return message;
        }

        message.put("message", "Error");
        return message;
    }

    public Contacto update(Long id, Contacto newDataContacto) {
        
        return repository.findById(id)
            .map((contacto) -> {
                contacto.setNombre(newDataContacto.getNombre());
               contacto.setCorreo(newDataContacto.getCorreo());
               contacto.setMensaje(newDataContacto.getMensaje());
               contacto.setTelefono(newDataContacto.getTelefono());
                return repository.save(contacto);
            })
            .orElseGet(() -> {
                return repository.save(newDataContacto);
            });

    }

    

}
