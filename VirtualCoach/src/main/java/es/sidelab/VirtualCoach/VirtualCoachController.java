package es.sidelab.VirtualCoach;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VirtualCoachController {
	
	@RequestMapping("/index")
	public String index() {
		
	return "/public/index";
 }
}

	

