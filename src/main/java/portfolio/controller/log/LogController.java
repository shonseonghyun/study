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
	
	
	//로그인
	@RequestMapping(value="login",method = RequestMethod.POST)
	public ModelAndView pflogincheck(@ModelAttribute MemberDTO member,HttpSession session,ModelAndView mav,HttpServletResponse response) {
		String name=memberservice.logincheck(member, session);
		
		//로그인 성공
		if(name!=null) {
			//redirect로 가는데 mav.addobject가 있을 경우 url에 키값 value값 표시댄다... 
			
			//자동로그인 클릭시
			if(member.getAutologin()!=null) {
				//세션id를 value로 하는 loginCookie생성
				Cookie cookie=new Cookie("loginCookie", session.getId());
				int amount= 60*60 *24 *7; //단위는 초단위이므로 1분*60=1hour *24 =1day * 7= 1week
				cookie.setMaxAge(amount);
				response.addCookie(cookie); //쿠키생성loginCookie
				//currentTimeMillis는 1/1000초 단위이므로 1000을 곱해줘야한다
				Date sessionLimit=new Date(System.currentTimeMillis()+(1000*amount));
				memberservice.keepLogin(member.getId(), session.getId(), sessionLimit);
			}
			mav.setViewName("redirect:/pf/main");
			return mav;
			
		}
		
		else {//로그인 실패
			mav.setViewName("pf/log/login");
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
	public String pflogout(HttpSession session,HttpServletResponse response,HttpServletRequest request) {
		//일단 로그인되어있는게 전제조건 id,name,sessionKey값이 존재할거다
		if(session.getAttribute("name")!=null) {
			String id=(String) session.getAttribute("id");
			//세션 날려버림
			memberservice.logout(session);
			
			//쿠키쪽
			Cookie cookie=WebUtils.getCookie(request, "loginCookie");
			if(cookie!=null) { //쿠키가 존재한다면
				cookie.setMaxAge(0);
				Date next=new Date(System.currentTimeMillis()) ;
				memberservice.keepLogin(id, cookie.getValue(), next);
				response.addCookie(cookie);
			}
		}
			
		return "redirect:/pf/main";
	}
	
	
	//아이디 중복확인
	@RequestMapping(value="idcheck",method = RequestMethod.POST)
	@ResponseBody
	public int pfidcheck(String id) {
		return memberservice.idcheck(id);
	}
}
