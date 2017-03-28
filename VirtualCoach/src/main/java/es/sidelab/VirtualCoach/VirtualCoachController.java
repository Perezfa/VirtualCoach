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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	
		
	@GetMapping("/")
	public String index(){
		
		return "index";
	}
	
	@GetMapping("/login")
    public String login(Model model) {
	  
	  List<Entrenador> entrenador=entrenador_repository.findAll();
	  model.addAttribute("Entrenador",entrenador);

	  return "login";
    }
	
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession sesion, HttpServletRequest request){
		model.addAttribute("admin", request.isUserInRole("ROLE_ADMIN"));
		//Chequeamos si existe el usuario
		//Cliente user=cliente_repository.findByUsuarioAndContraseña(username,password);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String usuario_name = authentication.getName();
		sesion = request.getSession();
		
		//Buscamos por nombre de usuario y no nombre real
		model.addAttribute("usuario",usuario_name);
		sesion.setAttribute("user",usuario_name);
		model.addAttribute("admin",request.isUserInRole("ROLE_ADMIN"));
		CargarEstadisticas(usuario_name, model);
				
		return "dashboard";
	}
	

	@GetMapping("/volver_inicio")
	public String inicio (Model model, HttpSession Sesion){
		
		String usuario= (String)Sesion.getAttribute("user");
		model.addAttribute("usuario", usuario);
		CargarEstadisticas(usuario, model);
		return "dashboard";
	}
	
	  
	@GetMapping("/usuario_no_encontrado")
	public String loginerror(){
		return "usuario_no_encontrado";
	}
	
	@GetMapping("/estadisticas")
	public String estadisticas(Model model,  HttpSession Sesion){
		String usuario= (String)Sesion.getAttribute("user");
		model.addAttribute("usuario", usuario);
		CargarEstadisticas(usuario, model);
		return "estadisticas";
	}
	
	@GetMapping("/calendario")
	public String calendario (Model model, HttpSession Sesion){
		String usuario= (String)Sesion.getAttribute("user");
		model.addAttribute("usuario", usuario);
		CargarEstadisticas(usuario, model);
		return "calendar";
	}
	
	@GetMapping("/publica")
	public String mostrarpublica (Model model, HttpSession sesion){
		
		String usuario= (String) sesion.getAttribute("user");
		Cliente cliente=cliente_repository.findByUsuario(usuario);
		List<Estadisticas> estadisticas_user=estadisticas_repository.findByCliente(cliente);
		model.addAttribute("cliente",cliente);
		model.addAttribute("estadisticas", estadisticas_user);
		return "table";
	}
	@GetMapping("/rating")
	public String mostrarRating (Model model, HttpSession Sesion){
		
		String usuario= (String)Sesion.getAttribute("user");
		model.addAttribute("usuario", usuario);
		CargarEstadisticas(usuario, model);
		return "rating";
	}
	@GetMapping("/email")
	public String enviarEmail (Model model){
		
		SocketClient email=new SocketClient(6969,"127.0.0.1");
		email.enviarDatos("Hola");
		
		return "dato_enviado";
	}
	
	
	

	public void CargarEstadisticas( String usuario, Model model){
		Cliente cliente=cliente_repository.findByNombre(usuario);
		List <Estadisticas> estadisticas=estadisticas_repository.findByCliente(cliente);
		model.addAttribute("estadistica", estadisticas);
		
		
	}

}
