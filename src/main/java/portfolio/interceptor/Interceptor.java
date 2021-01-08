package portfolio.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Interceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		//로그인이 되어있지 않다면 pf/login으로 보냄
		if(id==null) {
			response.sendRedirect("/pf/login");
			return false; //더 이상 컨트롤러 요청으로 가지 않도록 막는다
		}
		return true;
	}
}
