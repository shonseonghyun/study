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
	
	
	//�α��� �� Ȯ��
	@RequestMapping(value="login",method = RequestMethod.POST)
	public ModelAndView pflogincheck(@ModelAttribute MemberDTO member,HttpSession session,ModelAndView mav) {
		String name=memberservice.logincheck(member, session);
		
		if(name!=null) {
			//redirect�� ���µ� mav.addobject�� ���� ��� url�� Ű�� value�� ǥ�ô��... 
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
		
	//ȸ������
	@RequestMapping(value="sign",method = RequestMethod.POST)
	public String pfsignuppost(@ModelAttribute MemberDTO member) {
		memberservice.sign(member);
		return "redirect:/pf/login";
	}
	
	//�α׾ƿ�
	@RequestMapping("logout")
	public String pflogout(HttpSession session) {
		memberservice.logout(session);
		return "redirect:/pf/main";
	}
	
	
	//���̵� �ߺ�Ȯ��
	@RequestMapping(value="idcheck",method = RequestMethod.POST)
	@ResponseBody
	public int pfidcheck(String id) {
		return memberservice.idcheck(id);
	}
}
