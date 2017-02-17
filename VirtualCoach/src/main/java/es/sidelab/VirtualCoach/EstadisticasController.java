package es.sidelab.VirtualCoach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class EstadisticasController {
	@Autowired 
	private EstadisticasRepository estadisticas_repository;
	

	@GetMapping("/table")
	public String estadisticas(Model model) {
		
				model.addAttribute("estadisticas", estadisticas_repository.findAll());
				
			return "/public/table";
	}

	@PostMapping("")
	public String nuevaEstadistica(Model model, Estadisticas estadistica){
		
		estadisticas_repository.save(estadistica);
		return "guardar_estadisticas";
	}
=======
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EstadisticasController {
	@Autowired 
	private EstadisticasRepository estadistica_repository;
	
	public void estadistica(){
		
	estadistica_repository.save(new Estadisticas());

	}
	@RequestMapping("/table")
	public String rating(Model model) {
		
			
			return "/public/table";
	}

>>>>>>> 2aa78c82fc12bf0bb0651a45055dbaf31629cb90
}
