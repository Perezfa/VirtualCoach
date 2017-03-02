package es.sidelab.VirtualCoach;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;



public interface ClienteRepository extends CrudRepository<Cliente, Long> {	

	Cliente findByEmail (String email);
	Cliente findByUsuarioAndContraseña(String usuario,String contraseña);
	Cliente findByNombreAndContraseña(String nombre,String contraseña);
	Cliente findByUsuario(String usuario);
	Cliente findByNombre(String nombre);
	Cliente findByContraseña(String contraseña);
}
