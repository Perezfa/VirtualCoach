package es.sidelab.VirtualCoach;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseClientesLoader {
 @Autowired
 private ClienteRepository clienteRepository;
 @Autowired
 private EntrenadorRepository entrenador_repository;
 
 @PostConstruct
 private void initDatabase() {
	 
	//Entrenador 1
		entrenador_repository.save(new Entrenador("Pedro","Gonzalez","27","E"));
		//Entrenador 2
		entrenador_repository.save(new Entrenador("Juan","Pérez","25","E"));
		//Entrenador 3
		entrenador_repository.save(new Entrenador("David","Marchante","25","E"));
		//Entrenador 4
		entrenador_repository.save(new Entrenador("Pedro J.","Benito","41","E"));
		//Entrenador 5
		entrenador_repository.save(new Entrenador("Julio","Badillo","35","E"));
	 
	 Cliente cliente=new Cliente("Adrian","Pérez","123","perezoner@gmail.com","23","123","USER");
	 clienteRepository.save(cliente);

	 
 }
}

