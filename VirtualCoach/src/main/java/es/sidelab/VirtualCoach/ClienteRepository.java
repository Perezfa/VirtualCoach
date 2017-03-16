package es.sidelab.VirtualCoach;


import org.springframework.data.jpa.repository.JpaRepository;




public interface ClienteRepository extends JpaRepository<Cliente, Long> {	
<<<<<<< HEAD

	List<Cliente> findByNombre(String nombre);
	Cliente findByEmail (String email);
	Cliente findByNombreAndContraseña(String nombre,String contraseña);
	


=======

	Cliente findByEmail (String email);
	Cliente findByUsuarioAndContraseña(String usuario,String contraseña);
	Cliente findByNombreAndContraseña(String nombre,String contraseña);
	Cliente findByUsuario(String usuario);
	Cliente findByNombre(String nombre);
	Cliente findByContraseña(String contraseña);
>>>>>>> 31c133c79686a4805599892cd358bc0ceea562c3
}
