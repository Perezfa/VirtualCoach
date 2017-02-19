package es.sidelab.VirtualCoach;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClienteController {
	
	
	@Autowired
	private ClienteRepository cliente_repository;

	
	@RequestMapping(value="/registro", method=RequestMethod.POST)
	public String Registrarse(Model model, 
			@RequestParam String new_usu_username,@RequestParam String new_usu_lastname,@RequestParam String new_usu_email
			,@RequestParam String new_usu_name, @RequestParam String new_usu_age,@RequestParam String new_usu_rol,
			@RequestParam String new_usu_pass, @RequestParam String new_usu_rep_pass){
		
		
		//Si las contraseñan coinciden podemos crear usu
		//Más adelante tambien habria que poner metodo para saber que ese nombre de usu ya esta cogido o no
		if(new_usu_pass.equals(new_usu_rep_pass)){
			//Falta poner el valor del checkbox
	
			cliente_repository.save(new Cliente(new_usu_name,new_usu_lastname,new_usu_username,new_usu_email,new_usu_age,new_usu_pass,new_usu_rol));
			
			//Lo enseñamos donde ponga nombre_usu
			model.addAttribute("nombre_usu",cliente_repository.findByNombreAndContraseña(new_usu_name, new_usu_pass).toString());
		}
		
		
		return "registrado";
	}
	

	@RequestMapping("/inicio")
	public String Entrar(Model model,@RequestParam String username,@RequestParam String password){
		
		//Chequeamos si existe el usuario
		Cliente user=cliente_repository.findByNombreAndContraseña(username,password);
		if(user!=null){
				
			//Lo enseñamos donde ponga nombre_usu
			model.addAttribute("nombre_usu",username);
		}
		
		
		
		return "index";
	}

}


