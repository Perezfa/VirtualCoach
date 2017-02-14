package es.sidelab.VirtualCoach;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import model.Estadisticas;
import model.EstadisticasRepository;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String cliente(Model model){
		
		model.addAttribute("name", "World");
		
		return "/public/login";
	}
		

}
