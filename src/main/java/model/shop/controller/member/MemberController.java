package model.shop.controller.member;

import javax.servlet.http.HttpSession;

import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.shop.dto.member.MemberDTO;
import model.shop.service.member.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	MemberService memberservice;
	
	@RequestMapping("logindo")
	public String logindo() {
		return "member/dologin";
	}
	
	@RequestMapping("login_check")	
	public ModelAndView logincheck(@ModelAttribute MemberDTO member,HttpSession session) {
		String name=memberservice.loginCheck(member, session);
		ModelAndView mav=new ModelAndView();
		if(name!=null) {
			mav.setViewName("redirect:/shop/product/list");
		}else {
			mav.addObject("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
			mav.setViewName("/member/dologin");
		}
		return mav;	
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		memberservice.logout(session);
		return "redirect:/shop/product/list";
	}
	
}	
