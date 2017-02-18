package es.sidelab.VirtualCoach;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import es.sidelab.VirtualCoach.Cliente;
import es.sidelab.VirtualCoach.ClienteRepository;


@Controller
public class EstadisticasController {
	@Autowired 
	private EstadisticasRepository estadisticas_repository;
	@Autowired
	private ClienteRepository cliente_repository;
	@Autowired
	private RutinaRepository rutina_repository;


	@RequestMapping("/estadisticas")
	public String rating(Model model) {
		return "/public/estadisticas";
	}
	
	@GetMapping("/estadisticas/{id_estadisticas}/añadido")
	public String nuevaEstadisticaCliente(Model model, @PathVariable long id_estadisticas, Estadisticas estadistica, HttpSession sesion){
		
		Estadisticas estadisticas =estadisticas_repository.findOne(id_estadisticas);
		
		Cliente cliente = cliente_repository.findByEmail((String) sesion.getAttribute("email"));
		Rutina rutinaCliente = cliente.getRutina();
		estadisticas.getEstadisticasRutina().add(rutinaCliente);
		estadisticas_repository.save(estadisticas);
		
		
		return "/public/estadisticas";
	}
	
	@GetMapping("/estadisticas/{id_estadisticas}/eliminar")
	public String eliminarArticulo (Model model, @PathVariable long id_estadisticas ){
		
		Estadisticas estadisticas = estadisticas_repository.findOne(id_estadisticas);
		estadisticas_repository.delete(estadisticas);
		model.addAttribute("estadisticas", estadisticas_repository.findAll());
		return "/public/estadisticas";
	}
	

	@GetMapping("/estadisticas/{id_estadisticas}")
	public String verEstadisticas (Model model, @PathVariable long id_estadisticas){
		
		Estadisticas estadisticas = estadisticas_repository.findOne(id_estadisticas);
		model.addAttribute("estadisticas", estadisticas);
		model.addAttribute("rutina",rutina_repository.findByEstadisticas(estadisticas));
		return "index";
	}
}
