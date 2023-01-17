package augusto.HolaSpring.controllers;

import augusto.HolaSpring.Services.PersonaService;
import augusto.HolaSpring.entities.Persona;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InicioController {

    @Autowired
    private PersonaService personaServ;

    @GetMapping("/")
    public String incio(Model modelo) {
        List<Persona> personas = personaServ.listAll();
        modelo.addAttribute("personas", personas);
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores ){
        if (errores.hasErrors()) {
            return "modificar";
            
        }
        personaServ.crearPersona(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(Persona persona, Model model){
       persona= personaServ.buscarPorId(persona.getId()).orElse(null);
       model.addAttribute("persona",persona);
       return "modificar";
}
    
    @GetMapping("/eliminar/{id}")
    public String eliminar(Persona persona){
        personaServ.eliminar(persona);
      
       return "redirect:/";
}
}