package es.sidelab.VirtualCoach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

}
