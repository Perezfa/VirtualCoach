package es.sidelab.VirtualCoach;


import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames="VirtualCoach")
public interface ClienteRepository extends JpaRepository<Cliente, Long> {	

	@CacheEvict(allEntries=true)	
	Cliente save(Cliente cliente);
	
	@Cacheable
	Cliente findByEmail (String email);
	@Cacheable
	Cliente findByUsuarioAndContraseña(String usuario,String contraseña);
	@Cacheable
	Cliente findByNombreAndContraseña(String nombre,String contraseña);
	@Cacheable
	Cliente findByUsuario(String usuario);
	@Cacheable
	Cliente findByNombre(String nombre);
	@Cacheable
	Cliente findByContraseña(String contraseña);

}
