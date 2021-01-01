package model.shop.controller.cart;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.shop.dto.cart.CartDTO;
import model.shop.service.cart.CartService;

@Controller
@RequestMapping("/shop/cart/")
public class CartController {
	
	@Autowired
	CartService cartservice;
	
	@RequestMapping("list")
	public ModelAndView list(HttpSession session,ModelAndView mav) {
		String id=(String)session.getAttribute("id");
		Map<String,Object> map=new HashMap<>();
		map.put("list", cartservice.listCart(id));
		mav.addObject("map", map);
		mav.setViewName("cart/cart_list");
		return mav;
	}
	
	@RequestMapping("insert")
	public String list(@ModelAttribute CartDTO cart,HttpSession session) {
		//로그인 여부 체크를 위하여세션에 저장된 아이디 확인
		String id=(String)session.getAttribute("id");
		System.out.println(id);
		if(id!=null) {
			cart.setId(id);
			cartservice.insert(cart);
			return "redirect:/shop/cart/list";
		}
		else {
			return "redirect:/member/logindo";
		}
	}
	
	@RequestMapping("del")
	public String del(@RequestParam int cart_id) {
		cartservice.del(cart_id);
		return "redirect:list";
	}
	
	@RequestMapping("delall")
	public String del(HttpSession session) {
		String id=(String)session.getAttribute("id");
		cartservice.delall(id);
		return "redirect:list";
	}
	
	@RequestMapping("modify")
	public String modify(@RequestParam int[] amount,@RequestParam int[] cart_id) {
		System.out.println("controller 들어옴");
		for(int i=0;i<amount.length;i++) {
			if(amount[i]!=0) {
				cartservice.modify(cart_id[i],amount[i]);
			}
			else {
				cartservice.del(cart_id[i]);
			}
		}
		return "redirect:list";
	}
	
	
}
