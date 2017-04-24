package es.sidelab.VirtualCoach;


import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames="VirtualCoach")
public interface EstadisticasRepository extends JpaRepository<Estadisticas, Long>{
	

	@CacheEvict(allEntries=true)	
	Estadisticas save(Estadisticas estadisticas);
	
	@Cacheable
	List<Estadisticas> findByfecha(String fecha);
	@Cacheable
	List<Estadisticas>findBymarca(long marca);
	@Cacheable
	List<Estadisticas>findByCliente(Cliente cliente);


}
