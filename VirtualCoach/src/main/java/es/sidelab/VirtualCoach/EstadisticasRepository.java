package es.sidelab.VirtualCoach;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadisticasRepository extends JpaRepository<Estadisticas, Long>{
	List<Estadisticas> findByfecha(String fecha);
	List<Estadisticas>findBymarca(long marca);
	List<Estadisticas>findByCliente(Cliente cliente);


}
