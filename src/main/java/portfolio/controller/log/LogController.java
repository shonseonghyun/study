package portfolio.controller.log;

import java.sql.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import portfolio.dto.member.MemberDTO;
import portfolio.service.member.PfMemberService;

@Controller
@RequestMapping("/pf/")
public class LogController {

	
	@Autowired
	PfMemberService memberservice;
	
	@RequestMapping(value="login",method = RequestMethod.GET)
	public String pflogin(HttpSession session) {
		if(session.getAttribute("name")!=null) {
			memberservice.logout(session);
		}
		return "pf/log/login";
	}
	
	@RequestMapping(value="signup",method=RequestMethod.GET)
	public String pfsignup() {
			return "pf/log/signup";
	}
	
	
	//�α���
	@RequestMapping(value="login",method = RequestMethod.POST)
	public ModelAndView pflogincheck(@ModelAttribute MemberDTO member,HttpSession session,ModelAndView mav,HttpServletResponse response) {
		String name=memberservice.logincheck(member, session);
		
		//�α��� ����
		if(name!=null) {
			//redirect�� ���µ� mav.addobject�� ���� ��� url�� Ű�� value�� ǥ�ô��... 
			
			//�ڵ��α��� Ŭ����
			if(member.getAutologin()!=null) {
				//����id�� value�� �ϴ� loginCookie����
				Cookie cookie=new Cookie("loginCookie", session.getId());
				int amount= 60*60 *24 *7; //������ �ʴ����̹Ƿ� 1��*60=1hour *24 =1day * 7= 1week
				cookie.setMaxAge(amount);
				response.addCookie(cookie); //��Ű����loginCookie
				//currentTimeMillis�� 1/1000�� �����̹Ƿ� 1000�� ��������Ѵ�
				Date sessionLimit=new Date(System.currentTimeMillis()+(1000*amount));
				memberservice.keepLogin(member.getId(), session.getId(), sessionLimit);
			}
			mav.setViewName("redirect:/pf/main");
			return mav;
			
		}
		
		else {//�α��� ����
			mav.setViewName("pf/log/login");
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
	public String pflogout(HttpSession session,HttpServletResponse response,HttpServletRequest request) {
		//�ϴ� �α��εǾ��ִ°� �������� id,name,sessionKey���� �����ҰŴ�
		if(session.getAttribute("name")!=null) {
			String id=(String) session.getAttribute("id");
			//���� ��������
			memberservice.logout(session);
			
			//��Ű��
			Cookie cookie=WebUtils.getCookie(request, "loginCookie");
			if(cookie!=null) { //��Ű�� �����Ѵٸ�
				cookie.setMaxAge(0);
				Date next=new Date(System.currentTimeMillis()) ;
				memberservice.keepLogin(id, cookie.getValue(), next);
				response.addCookie(cookie);
			}
		}
			
		return "redirect:/pf/main";
	}
	
	
	//���̵� �ߺ�Ȯ��
	@RequestMapping(value="idcheck",method = RequestMethod.POST)
	@ResponseBody
	public int pfidcheck(String id) {
		return memberservice.idcheck(id);
	}
}
