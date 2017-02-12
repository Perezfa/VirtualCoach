package model;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadisticasRepository extends JpaRepository<Estadisticas, Long>{
	ArrayList<Estadisticas> findByfecha(Date fecha);
	ArrayList<Estadisticas>findBymarca(float marca);

}
