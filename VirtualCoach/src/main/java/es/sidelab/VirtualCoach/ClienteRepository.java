package es.sidelab.VirtualCoach;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ClienteRepository extends JpaRepository<Cliente, Long> {	
	List<Cliente> findBynombre(String nombre);
	

}
