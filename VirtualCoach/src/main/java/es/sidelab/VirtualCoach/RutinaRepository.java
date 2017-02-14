package es.sidelab.VirtualCoach;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RutinaRepository extends JpaRepository<Rutina, Long>{
	List<Rutina> findBytipo(String tipo);
	List <Rutina> findByduracion(int duracion);
}
