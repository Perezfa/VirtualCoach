package es.sidelab.VirtualCoach;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/estadisticas/{id_estadisticas}/añadido")
	public String nuevaEstadisticaCliente(Model model, @PathVariable long id_estadisticas, @RequestParam float marca, HttpSession sesion){
		
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
	
	//Al pulsar el boton Guardar, guardamos la estadistica en la BBDD y la mostramos en algun sitio
	@RequestMapping("/guardar_estadistica")
	public String guardarEstadistica(Model model, @RequestParam float marca, @RequestParam String fecha, @RequestParam String  ejercicio){
		
		//Orden constructor: fecha,marca,ejercicio
		estadisticas_repository.save(new Estadisticas(fecha,marca,ejercicio));
		
		//Para mostrar, buscamos por fecha y ejercicio
		//Solo nos va a mostrar las estadisticas que acabemos de guardar, o que sean misma fecha y ejercicio
		//Si quisieramos mostrar todas habria que buscar por solo fecha, solo ejercicio, o simplemente poner todas
		
		//No se si al ser una lista se rellenara la tabla o lo que sea
		//Descomentar cuanto este el html
		//model.addAttribute("tabla_estadisticas",estadisticas_repository.findByFechaAndEjercicio(fecha,ejercicio));
		
		
		return "estadisticas";
	}

}
