package es.sidelab.VirtualCoach;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {
	@RequestMapping("/dashboard")
	public String greeting(Model model) {
		
			model.addAttribute("name", "World");
			
			return "/public/dashboard";
 }
	@PostMapping("/login")
	public String LoginController(Model model){
		
		model.addAttribute("user", "usuario1");
		
				return "/public/login";
		
	}
}