
package augusto.HolaSpring.repositories;

import augusto.HolaSpring.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonaRepository extends JpaRepository<Persona, String>{
    
    
}


