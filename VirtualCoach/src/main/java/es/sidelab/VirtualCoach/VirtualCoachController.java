package es.sidelab.VirtualCoach;

import javax.annotation.PostConstruct;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VirtualCoachController {
<<<<<<< HEAD
=======

	@Autowired
	private ClienteRepository cliente_repository;
	
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
>>>>>>> 2aa78c82fc12bf0bb0651a45055dbaf31629cb90
	
	@RequestMapping("/index")
	public String index() {
		
	return "/public/index";
 }
}

	
<<<<<<< HEAD

	
=======
	@Controller
	public class GreetingController {
		@RequestMapping("/index")
		public String greeting(Model model) {
			
				
				return "/public/index";
	 }
	}

	
}

	
>>>>>>> 2aa78c82fc12bf0bb0651a45055dbaf31629cb90

