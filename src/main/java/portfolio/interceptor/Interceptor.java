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
		//�α����� �Ǿ����� �ʴٸ� pf/login���� ����
		if(id==null) {
			response.sendRedirect("/pf/login");
			return false; //�� �̻� ��Ʈ�ѷ� ��û���� ���� �ʵ��� ���´�
		}
		return true;
	}
}
