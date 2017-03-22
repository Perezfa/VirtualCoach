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
 private EntrenadorRepository entr_repo;
 
 @PostConstruct
 private void initDatabase() {
	 
	 Cliente cliente=new Cliente("Adrian","Pérez","123","perezoner@gmail.com","23","123","USER");
	 clienteRepository.save(cliente);

	 
 }
}

