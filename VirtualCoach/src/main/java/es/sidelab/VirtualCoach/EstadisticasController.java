package es.sidelab.VirtualCoach;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class EstadisticasController {
	@Autowired 
	private EstadisticasRepository estadisticas_repository;

	
	@PostMapping("/añadirestadisticas")
	public String nuevaEstadisticaCliente(Model model, Estadisticas estadistica){
		
		estadisticas_repository.save(estadistica);
		model.addAttribute("estadistica",estadistica);
		
		return "estadisticas_añadidas";
	}
	
	@RequestMapping("/eliminar_estadisticas")
	public String eliminarArticulo (Model model, @PathVariable long id_estadisticas ){
		
		Estadisticas estadisticas = estadisticas_repository.findOne(id_estadisticas);
		estadisticas_repository.delete(estadisticas);
		model.addAttribute("estadisticas", estadisticas_repository.findAll());
		return "estadisticas_eliminadas";
	}
	

	/*@GetMapping("/estadisticas/{id_estadisticas}")
	public String verEstadisticas (Model model, @PathVariable long id_estadisticas){
		
		Estadisticas estadisticas = estadisticas_repository.findOne(id_estadisticas);
		model.addAttribute("estadisticas", estadisticas);
		model.addAttribute("rutina",rutina_repository.findByEstadisticas(estadisticas));
		return "index";
	}*/

}
