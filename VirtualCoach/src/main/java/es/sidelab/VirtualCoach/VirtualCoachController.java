package es.sidelab.VirtualCoach;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

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
	private EstadisticasRepository estadisticas_repository;
	
	@PostConstruct
	
	public void init(){
		
		cliente_repository.save(new Cliente ("Adrián","Pérez","123","perezoner@gmail.com", "23","123", "C"));
		cliente_repository.save(new Cliente ("Óscar","Repiso","456","orb@gmail.com", "23","456", "E"));
	}

	@GetMapping("/volver_inicio")
	public String inicio (Model model, HttpSession Sesion){
		
		String usuario= (String)Sesion.getAttribute("user");
		model.addAttribute("usuario", usuario);
		Cliente cliente =cliente_repository.findByUsuario(usuario);
		List <Estadisticas> estadisticas=estadisticas_repository.findByCliente(cliente);
		model.addAttribute("estadistica", estadisticas);
		return "dashboard";
	}
	@GetMapping("/")
	public String registro(Model model){
		return "login";
	}
	@GetMapping("/calendario")
	public String calendario (Model model){
		return "calendar";
	}
	@GetMapping("/rating")
	public String rating (Model model){
		return "table";
	}
	
}
