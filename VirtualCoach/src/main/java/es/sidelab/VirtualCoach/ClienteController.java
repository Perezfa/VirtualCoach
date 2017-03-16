package es.sidelab.VirtualCoach;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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

<<<<<<< HEAD
	@PostMapping
	public void cliente(){
		cliente_repository.save(new Cliente("Adrián", "Pérez", "aperez@gmail.com","22", "C","12345-asdf"));
		cliente_repository.save(new Cliente("Oscar", "Repiso","orb@gmail.com", "21", "C","7894-qwerty"));

=======
	
	@PostMapping("/registro_nuevo")
	public String Registrarse(Model model, 
			@RequestParam String new_usu_username,@RequestParam String new_usu_lastname,@RequestParam String new_usu_email
			,@RequestParam String new_usu_name, @RequestParam String new_usu_age,
			@RequestParam String new_usu_pass, @RequestParam String new_usu_rep_pass,@RequestParam long id){
		
>>>>>>> 31c133c79686a4805599892cd358bc0ceea562c3
		
		//Si las contraseñan coinciden podemos crear usu
		//Más adelante tambien habria que poner metodo para saber que ese nombre de usu ya esta cogido o no
		if(new_usu_pass.equals(new_usu_rep_pass)){
			Entrenador entrenador=entrenador_repository.findOne(id);
			
			//Falta poner el valor del checkbox
			Cliente cliente=new Cliente(new_usu_name,new_usu_lastname,new_usu_username,new_usu_email,new_usu_age,new_usu_pass,"C", entrenador);
			cliente_repository.save(cliente);
						//Lo enseñamos donde ponga usu_username
			model.addAttribute("name",cliente_repository.findByNombre(new_usu_name).toString());
			
			return "registrado";
		}else{
			
			return "contraseña_erronea";
		}

	}
	
<<<<<<< HEAD
	@GetMapping("/login")
	public String cliente(Model model){
		
		model.addAttribute("user",cliente_repository.findByNombre("Oscar"));

		return "public/login";
		
=======
	@RequestMapping("/inicio")
	public String Entrar(Model model,@RequestParam String username,@RequestParam String password, HttpSession sesion){
		
		//Chequeamos si existe el usuario
		Cliente user=cliente_repository.findByUsuarioAndContraseña(username,password);
		
		if(user!=null){
			//Buscamos por nombre de usuario y no nombre real
			String usuario=cliente_repository.findByUsuario(username).getUsuario();
			model.addAttribute("usuario",usuario);
			sesion.setAttribute("user",usuario);
			return "dashboard";
			
		}else{
			
			
			return "usuario_no_encontrado";
						
		}

>>>>>>> 31c133c79686a4805599892cd358bc0ceea562c3
	}

}


