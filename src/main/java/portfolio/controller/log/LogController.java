package portfolio.controller.log;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import portfolio.dto.member.MemberDTO;
import portfolio.service.member.PfMemberService;

@Controller
@RequestMapping("/pf/")
public class LogController {

	
	@Autowired
	PfMemberService memberservice;
	
	@RequestMapping(value="login",method = RequestMethod.GET)
	public String pflogin() {
		return "pf/log/login";
	}
	
	@RequestMapping(value="signup",method=RequestMethod.GET)
	public String pfsignup() {
			return "pf/log/signup";
	}
	
	
	//로그인 시 확인
	@RequestMapping(value="login",method = RequestMethod.POST)
	public ModelAndView pflogincheck(@ModelAttribute MemberDTO member,HttpSession session,ModelAndView mav) {
		String name=memberservice.logincheck(member, session);
		
		if(name!=null) {
			//redirect로 가는데 mav.addobject가 있을 경우 url에 키값 value값 표시댄다... 
			mav.setViewName("redirect:/pf/main");
			return mav;
		}
		else {
			mav.setViewName("pf/log/login");
//			mav.setViewName("redirect:login");
			mav.addObject("name",2);
			return mav;
		}
	}
		
	//회원가입
	@RequestMapping(value="sign",method = RequestMethod.POST)
	public String pfsignuppost(@ModelAttribute MemberDTO member) {
		memberservice.sign(member);
		return "redirect:/pf/login";
	}
	
	//로그아웃
	@RequestMapping("logout")
	public String pflogout(HttpSession session) {
		memberservice.logout(session);
		return "redirect:/pf/main";
	}
	
	
	//아이디 중복확인
	@RequestMapping(value="idcheck",method = RequestMethod.POST)
	@ResponseBody
	public int pfidcheck(String id) {
		return memberservice.idcheck(id);
	}
}
