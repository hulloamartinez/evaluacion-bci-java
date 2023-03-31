package cl.hulloa.evaluation.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.hulloa.evaluation.models.Usuario;

@Repository
public interface UserInterface extends JpaRepository<Usuario,UUID>{
	
	

}
