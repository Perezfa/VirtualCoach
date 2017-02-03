package es.sidelab.VirtualCoach;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {
	@RequestMapping("/dashboard")
	public String greeting(Model model) {
		
			model.addAttribute("name", "World");
			
			return "/public/dashboard";
 }
}