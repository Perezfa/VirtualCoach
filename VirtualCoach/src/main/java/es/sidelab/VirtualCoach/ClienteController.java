package es.sidelab.VirtualCoach;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;


@Controller

public class ClienteController {
	
	
	@Autowired
	private ClienteRepository cliente_repository;
	@Autowired
	private EntrenadorRepository entrenador_repository;
	

	
	@PostMapping("/registro_nuevo")

	public String Registrarse(Model model,Cliente cliente,@RequestParam String new_usu_rep_pass,@RequestParam long id){

		String contraseña=cliente.getContraseña();
		String nom_usu_new=cliente.getUsuario();
		String nombre=cliente.getNombre();
		
		//Si las contraseñan coinciden podemos crear usu
		//Más adelante tambien habria que poner metodo para saber que ese nombre de usu ya esta cogido o no

		if(contraseña.equals(new_usu_rep_pass)){
			Cliente nom_usu=cliente_repository.findByUsuario(nom_usu_new);
			
			//Buscamos si existe un usuario con mismo nombre o mismo nombre de usuario
			if(nom_usu==null){

				Entrenador entrenador=entrenador_repository.findOne(id);
				//seteamos entrenador
				cliente.setEntrenador(entrenador);
				cliente.setContraseña(new BCryptPasswordEncoder().encode(contraseña));
				cliente_repository.save(cliente);
							//Lo enseñamos donde ponga usu_username
				model.addAttribute("name",cliente.getUsuario().toString());
				try{
					new SendEmail().send(cliente.getEmail(), "registro","Gracias por registrarte en VirtualCoach");
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}else{
				return "usuario_repetido";
			}

			
			return "registrado";
		}else{
			
			return "contraseña_erronea";
		}

	}

	}



