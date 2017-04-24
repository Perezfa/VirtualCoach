package es.sidelab.VirtualCoach;


import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import es.sidelab.VirtualCoach.Estadisticas;

@CacheConfig(cacheNames="VirtualCoach")
public interface RutinaRepository extends JpaRepository<Rutina, Long>{
	
	@CacheEvict(allEntries=true)	
	Rutina save(Rutina rutina);
	
	@Cacheable
	List<Rutina> findBytipo(String tipo);
	@Cacheable
	List <Rutina> findByduracion(int duracion);
	@Cacheable
	List <Rutina> findByEstadisticas(Estadisticas estadisticas);
}
