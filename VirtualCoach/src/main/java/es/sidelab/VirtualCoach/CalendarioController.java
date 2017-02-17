package es.sidelab.VirtualCoach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalendarioController {
	@Autowired 
	private RutinaRepository rutina_repository;

	
	@RequestMapping("/calendar")
	public String rating(Model model) {
		
			
			return "/public/calendar";
}

}
