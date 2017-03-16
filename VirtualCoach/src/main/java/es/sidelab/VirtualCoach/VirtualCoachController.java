package es.sidelab.VirtualCoach;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
<<<<<<< HEAD
=======
import org.springframework.security.web.csrf.CsrfToken;
>>>>>>> 31c133c79686a4805599892cd358bc0ceea562c3
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
<<<<<<< HEAD
=======
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
>>>>>>> 31c133c79686a4805599892cd358bc0ceea562c3

@Controller
public class VirtualCoachController {

	@Autowired
	private ClienteRepository cliente_repository;
<<<<<<< HEAD
	@Autowired 
	private EstadisticasRepository estadistica_repository;
	
=======
>>>>>>> 31c133c79686a4805599892cd358bc0ceea562c3
	@Autowired
	private EstadisticasRepository estadisticas_repository;
	@Autowired
	private EntrenadorRepository entrenador_repository;
	
	
	
<<<<<<< HEAD
	@RequestMapping("/login")
	public String cliente(Model model){
				
		return "/public/login";
	}
	
	@PostMapping("/Registro")
	public String Registrarse(Model model, 
			@RequestParam String new_usu_username,@RequestParam String new_usu_lastname,@RequestParam String new_usu_email
			,@RequestParam String new_usu_age,@RequestParam String new_usu_rol,
			@RequestParam String new_usu_pass, @RequestParam String new_usu_rep_pass){
		
		
		//Si las contraseñan coinciden podemos crear usu
		//Más adelante tambien habria que poner metodo para saber que ese nombre de usu ya esta cogido o no
		if(new_usu_pass.equals(new_usu_rep_pass)){
			//Falta poner el valor del checkbox
	
			cliente_repository.save(new Cliente(new_usu_username,new_usu_lastname,new_usu_email,new_usu_age,new_usu_pass,new_usu_rol));
			
			//Lo enseñamos donde ponga nombre_usu
			model.addAttribute("nombre_usu",cliente_repository.findByNombreAndContraseña(new_usu_username, new_usu_pass).toString());
		}
		
		
		return "/public/index";
	}
	

	@PostMapping("/Entrar")
	public String Entrar(Model model, 
			@RequestParam String username,@RequestParam String password){
		
		//Chequeamos si existe el usuario
		Cliente user=cliente_repository.findByNombreAndContraseña(username,password);
		if(user!=null){
				
			//Lo enseñamos donde ponga nombre_usu
			model.addAttribute("nombre_usu",user.toString());
		}
		
		
		return "/public/index";
	}
	
	


	
=======
		@PostConstruct
		public void init(){
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
		
		Entrenador entrenador1=entrenador_repository.findBynombre("Pedro");
		Entrenador entrenador2=entrenador_repository.findBynombre("Juan");
		Entrenador entrenador3=entrenador_repository.findBynombre("David");
		Entrenador entrenador4=entrenador_repository.findBynombre("Pedro J.");
		Entrenador entrenador5=entrenador_repository.findBynombre("Julio");

		
		model.addAttribute("Entrenador1",entrenador1);
		model.addAttribute("Entrenador2",entrenador2);
		model.addAttribute("Entrenador3",entrenador3);
		model.addAttribute("Entrenador4",entrenador4);
		model.addAttribute("Entrenador5",entrenador5);
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
>>>>>>> 31c133c79686a4805599892cd358bc0ceea562c3
}
