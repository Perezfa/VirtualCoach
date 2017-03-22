package es.sidelab.VirtualCoach;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class ClienteController {
	
	
	@Autowired
	private ClienteRepository cliente_repository;
	@Autowired
	private EntrenadorRepository entrenador_repository;


	
	@PostMapping("/registro_nuevo")

	public String Registrarse(Model model,Cliente cliente, @RequestParam String new_usu_rep_pass,@RequestParam long id){

		String contraseña=cliente.getContraseña();
		
		//Si las contraseñan coinciden podemos crear usu
		//Más adelante tambien habria que poner metodo para saber que ese nombre de usu ya esta cogido o no

		if(contraseña.equals(new_usu_rep_pass)){


			Entrenador entrenador=entrenador_repository.findOne(id);
			//seteamos entrenador
			cliente.setEntrenador(entrenador);
			List<String> rol = new ArrayList<String>();
			rol.add("USER");
			cliente.setRol(rol);
			

			cliente_repository.save(cliente);
						//Lo enseñamos donde ponga usu_username
			model.addAttribute("name",cliente.getUsuario().toString());

			
			return "registrado";
		}else{
			
			return "contraseña_erronea";
		}

	}

	@RequestMapping("/login")
	public String Entrar(Model model,@RequestParam String username,@RequestParam String password, HttpSession sesion, HttpServletRequest request){
		
		//Chequeamos si existe el usuario
		Cliente user=cliente_repository.findByUsuarioAndContraseña(username,password);
		
	
			//Buscamos por nombre de usuario y no nombre real
			String usuario=cliente_repository.findByUsuario(username).getUsuario();
			model.addAttribute("usuario",usuario);
			sesion.setAttribute("user",usuario);
			model.addAttribute("admin",request.isUserInRole("ADMIN"));
			return "dashboard";
			
		}


	}



