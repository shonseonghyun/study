package portfolio.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PFHomeController {
	
	@RequestMapping("/pf/main")
	public String pfmain() {
		return "pf/main";
	}
	
}
