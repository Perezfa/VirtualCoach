package es.sidelab.VirtualCoach;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Long>  {
	
	Entrenador findBynombre(String nombre);
	Entrenador findByapellido(String apellido);
	Entrenador findByrol(String rol);

}
