package model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

public class VirtualCoachController {
	@Autowired
	private ClienteRepository cliente_repository;
	
	@PostConstruct
	public void cliente(){
		cliente_repository.save(new Cliente("Adrián", "Pérez", "22", "C"));
		
	}
	
	@Autowired
	private EntrenadorRepository entrenador_repository;
	@PostConstruct
	public void entrenador(){
		entrenador_repository.save(new Entrenador("Óscar", "Repiso", "2", "E"));
		
	}
	@Autowired 
	private EstadisticasRepository estadistica_repository;
	
	@Autowired
	private RutinaRepository rutina_repository;
	
	
	
	

}
