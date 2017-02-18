package es.sidelab.VirtualCoach;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import es.sidelab.VirtualCoach.Estadisticas;

public interface RutinaRepository extends JpaRepository<Rutina, Long>{
	List<Rutina> findBytipo(String tipo);
	List <Rutina> findByduracion(int duracion);
	List <Rutina> findByEstadisticas(Estadisticas estadisticas);
}
