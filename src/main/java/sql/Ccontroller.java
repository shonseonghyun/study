package sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ccontroller {
	@Autowired
	CartService service;
	
	
	@RequestMapping("/cart")
	public String ca(Model model) {
		
		model.addAttribute("c", service.viewAll());
		return "sql/cart";
	}
	
	@RequestMapping("/cart/write")
	public String write() {
		return "sql/writecart";
	}
	
//	@RequestMapping("/cart/insert")
	@RequestMapping(value = "/cart/insert",method = RequestMethod.POST)
	public String insert(@ModelAttribute Cart cart) {
		service.insert(cart);
		return "redirect:/cart";
	}
	
	@RequestMapping("/cart/detail")
	public String detail(@RequestParam String id,Model model) {
		model.addAttribute("detail", service.detail(id));
		return "sql/detail";
	}
	
	@RequestMapping("/cart/update")	
	public String update(@ModelAttribute Cart cart,Model model) {
		boolean result=service.check(cart.getId(),cart.getProduct_id());
		System.out.println(result);
		if(result) {
			service.update(cart);
			return "redirect:/cart";
		}
		else {
			model.addAttribute("detail", cart);
			model.addAttribute("message", "pid가 옳지 않습니다");
			return "sql/detail";
		}
	}
	@RequestMapping("/cart/delete")
	public String delete(@ModelAttribute Cart cart,Model model) {
		boolean result= service.check(cart.getId(),cart.getProduct_id());
		if(result) {
			service.delete(cart.getId());
			return "redirect:/cart";
		}
		else {
			model.addAttribute("message", "일치하지 않는 비밀번호입니다.");
			model.addAttribute("detail", cart);
			return "sql/detail";
		}
	}

}
