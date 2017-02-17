package es.sidelab.VirtualCoach;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadisticasRepository extends JpaRepository<Estadisticas, Long>{
	List<Estadisticas> findByfecha(Date fecha);
	List<Estadisticas>findBymarca(float marca);

}
