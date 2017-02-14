package es.sidelab.VirtualCoach;

import javax.annotation.PostConstruct;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VirtualCoachController {

	@Autowired
	private ClienteRepository cliente_repository;
	@Autowired 
	private EstadisticasRepository estadistica_repository;
	
	@Autowired
	private RutinaRepository rutina_repository;
	@Autowired
	private EntrenadorRepository entrenador_repository;
	
	
	
	@PostConstruct
	public void cliente(){
		cliente_repository.save(new Cliente("Adrián", "Pérez", "22", "C"));
		cliente_repository.save(new Cliente("Oscar", "Repiso", "21", "C"));

		
	}
	
	@PostConstruct
	public void entrenador(){
	//	entrenador_repository.save(new Entrenador("Óscar", "Repiso", "2", "E"));
		
	}
	
	@RequestMapping("/login")
	public String cliente(Model model){
		
		model.addAttribute("name",cliente_repository.findBynombre("Oscar"));
		
		
		return "/public/login";
	}
	
	@Controller
	public class GreetingController {
		@RequestMapping("/index")
		public String greeting(Model model) {
			
				model.addAttribute("name", "World");
				
				return "/public/index";
	 }
	}

	
}
