package es.sidelab.VirtualCoach;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GoogleCharts {
	@Autowired 
	private EstadisticasRepository estadisticas_repository;
	@Autowired
	private ClienteRepository cliente_repository;
	@GetMapping("/mostrarestadisticasgoogle")
	public Estadisticas estadisticas(){
		
		return new Estadisticas("Pepe","Vendo moto", "...");
	}
 
 }

