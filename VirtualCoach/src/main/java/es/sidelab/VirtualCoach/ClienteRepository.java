package es.sidelab.VirtualCoach;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ClienteRepository extends JpaRepository<Cliente, Long> {	

	List<Cliente> findByNombre(String nombre);
	Cliente findByEmail (String email);
	Cliente findByNombreAndContraseña(String nombre,String contraseña);
	


}
