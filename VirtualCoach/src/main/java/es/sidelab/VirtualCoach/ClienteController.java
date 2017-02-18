package es.sidelab.VirtualCoach;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class ClienteController {
	
	
	@Autowired
	private ClienteRepository cliente_repository;

	@PostMapping
	public void cliente(){
		cliente_repository.save(new Cliente("Adrián", "Pérez", "aperez@gmail.com","22", "C"));
		cliente_repository.save(new Cliente("Oscar", "Repiso","orb@gmail.com", "21", "C"));

		
	}
	
	@GetMapping("/login")
	public String cliente(Model model){
		
		model.addAttribute("user",cliente_repository.findByNombre("Oscar"));
		
		
		return "/public/login";
	}
}


