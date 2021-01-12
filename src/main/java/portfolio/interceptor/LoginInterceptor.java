package portfolio.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import portfolio.dto.member.MemberDTO;
import portfolio.service.member.PfMemberService;


// pf/main
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	PfMemberService memberservice;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");

		if(id==null) { //로그인 된 세션이 없는경우
			Cookie cookie=WebUtils.getCookie(request, "loginCookie");
			if(cookie!=null) { //자동로그인 쿠키가 존재한다면 이 쿠키로 key값으로 찾는다
				String sessionId=cookie.getValue();
				MemberDTO dto=memberservice.checkUserwithSessionkey(sessionId);
				
				//찾은 사용자가 존재할 경우
				if(dto!=null) {
					session.setAttribute("id",dto.getId());
					session.setAttribute("name",dto.getName());
					return true;
				}
			}
			response.sendRedirect("/pf/login");
			return false; //더 이상 컨트롤러 요청으로 가지 않도록 막는다
		}
		return true;
	}
}
