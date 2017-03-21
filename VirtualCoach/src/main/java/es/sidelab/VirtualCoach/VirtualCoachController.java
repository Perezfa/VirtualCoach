package es.sidelab.VirtualCoach;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Controller
public class VirtualCoachController {

	@Autowired
	private ClienteRepository cliente_repository;


	@Autowired
	private EstadisticasRepository estadisticas_repository;
	@Autowired
	private EntrenadorRepository entrenador_repository;
	
	
		@PostConstruct
		public void init(){
			//Administrador
			cliente_repository.save(new Cliente("Oscar","Repiso","oscar","oscarrepiso@gmail.com","21","admin","ROLE_ADMIN",null));
			//Entrenador 1
			entrenador_repository.save(new Entrenador("Pedro","Gonzalez","27","E"));
			//Entrenador 2
			entrenador_repository.save(new Entrenador("Juan","Pérez","25","E"));
			//Entrenador 3
			entrenador_repository.save(new Entrenador("David","Marchante","25","E"));
			//Entrenador 4
			entrenador_repository.save(new Entrenador("Pedro J.","Benito","41","E"));
			//Entrenador 5
			entrenador_repository.save(new Entrenador("Julio","Badillo","35","E"));

		
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
	public String login(Model model,  HttpServletRequest request){
		
		List<Entrenador> entrenador=entrenador_repository.findAll();
	

		model.addAttribute("Entrenador",entrenador);
	
		
		return "login";
	}
	@GetMapping("/estadisticas")
	public String estadisticas(Model model,  HttpServletRequest request){
		return "estadisticas";
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
