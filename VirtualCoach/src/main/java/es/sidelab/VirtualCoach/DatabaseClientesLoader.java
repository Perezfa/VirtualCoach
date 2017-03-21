package es.sidelab.VirtualCoach;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseClientesLoader {
 @Autowired
 private ClienteRepository clienteRepository;
 @PostConstruct
 private void initDatabase() {

 clienteRepository.save(
 new Cliente("Adrian","Pérez","123", "perezoner@gmail.com", "123", "123"));
 
 }
}

