package model;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	ArrayList <Cliente> findBynombre(String nombre);
	ArrayList <Cliente> findByapellido(String apellido);
	ArrayList <Cliente> findByrol(String rol);

	

}
