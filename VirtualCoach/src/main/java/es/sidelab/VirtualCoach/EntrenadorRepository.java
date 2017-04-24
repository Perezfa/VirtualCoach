package es.sidelab.VirtualCoach;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames="VirtualCoach")
public interface EntrenadorRepository extends JpaRepository<Entrenador, Long>  {
	
	@CacheEvict(allEntries=true)	
	Entrenador save(Entrenador entrenador);
	
	@Cacheable
	Entrenador findBynombre(String nombre);
	@Cacheable
	Entrenador findByapellido(String apellido);
	@Cacheable
	Entrenador findByrol(String rol);

}
