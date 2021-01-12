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

		if(id==null) { //�α��� �� ������ ���°��
			Cookie cookie=WebUtils.getCookie(request, "loginCookie");
			if(cookie!=null) { //�ڵ��α��� ��Ű�� �����Ѵٸ� �� ��Ű�� key������ ã�´�
				String sessionId=cookie.getValue();
				MemberDTO dto=memberservice.checkUserwithSessionkey(sessionId);
				
				//ã�� ����ڰ� ������ ���
				if(dto!=null) {
					session.setAttribute("id",dto.getId());
					session.setAttribute("name",dto.getName());
					return true;
				}
			}
			response.sendRedirect("/pf/login");
			return false; //�� �̻� ��Ʈ�ѷ� ��û���� ���� �ʵ��� ���´�
		}
		return true;
	}
}
