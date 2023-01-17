package augusto.HolaSpring.Services;

import augusto.HolaSpring.entities.Persona;
import augusto.HolaSpring.repositories.PersonaRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class PersonaService {

    @Autowired
    private PersonaRepository personarepo;

    @Transactional
    public Persona crearPersona(Persona persona) {
        return personarepo.save(persona);
    }

    @Transactional(readOnly = true)
    public List<Persona> listAll() {
        
       return personarepo.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorId(String id) {
        return personarepo.findById(id);
    }

    
    public void eliminar(Persona persona) {
        personarepo.delete(persona);
    }
    
    
    public void modificarPersona(Persona persona) {
        personarepo.save(persona);
    }

}
