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
		cliente_repository.save(new Cliente("Adrián", "Pérez", "22", "C"));
		cliente_repository.save(new Cliente("Oscar", "Repiso", "21", "C"));

		
	}
	
	@GetMapping("/login")
	public String cliente(Model model){
		
		model.addAttribute("user",cliente_repository.findBynombre("Oscar"));
		
		
		return "/public/login";
	}
}


