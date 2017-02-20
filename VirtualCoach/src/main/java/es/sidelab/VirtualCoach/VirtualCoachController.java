package es.sidelab.VirtualCoach;

import javax.annotation.PostConstruct;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	
	@RequestMapping("/index")
	 public String index(Model model) {
	 return "/public/index";
	 }
	@RequestMapping("/calendario")
	 public String calendario(Model model) {
	 return "/public/calendario";
	 }
	@RequestMapping("/estadisticas")
	 public String estadisticas(Model model) {
	 return "/public/estadisticas";
	 }
	
	
	
	


	
}
