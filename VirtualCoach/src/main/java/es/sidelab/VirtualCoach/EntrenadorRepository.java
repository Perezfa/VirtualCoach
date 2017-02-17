package es.sidelab.VirtualCoach;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Long>  {
	
	List<Entrenador> findBynombre(String nombre);
	List <Entrenador> findByapellido(String apellido);
	List <Entrenador> findByrol(String rol);

}
