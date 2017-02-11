package model;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RutinaRepository extends JpaRepository<Rutina, Long>{
	ArrayList<Rutina> findBytipo(String tipo);
	ArrayList <Rutina> findByduracion(int duracion);
}
