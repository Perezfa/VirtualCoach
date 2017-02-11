package model;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Long>  {
	
	ArrayList<Entrenador> findBynombre(String nombre);
	ArrayList <Entrenador> findByapellido(String apellido);
	ArrayList <Entrenador> findByrol(String rol);

}
