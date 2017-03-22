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
 @PostConstruct
 private void initDatabase() {

	 Cliente cliente=new Cliente("Adrian","Pérez","123","perezoner@gmail.com","123","123");
	 List<String> rol = new ArrayList<String>();
		rol.add("ROLE_USER");
		cliente.setRol(rol);
		clienteRepository.save(cliente);
	 
	 
 }
}

