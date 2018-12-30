package member.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Controller> list = null;
	String charset = null;
	
 	
	public void init(ServletConfig sc) throws ServletException {
		charset = sc.getInitParameter("charset");
		list = new HashMap<String, Controller>();
		list.put("/memberUserInsert.do", new MemberUserInsertController());
		list.put("/memberLogin.do", new MemberLoginController());
		list.put("/memberUserUpdate.do", new MemberUserUpdateController());
		list.put("/memberSellerUpdate.do", new MemberSellerUpdateController());
		list.put("/memberSaleInsert.do",new MemberSaleInsertController());
		list.put("/memberSaleDelete.do", new MemberSaleDeleteController());
		list.put("/memberSaleUpdate.do", new MemberSaleUpdateController());
		list.put("/memberSaleList.do", new MemberSaleListController());
		list.put("/memberSellerLogin.do", new MemberSellerLoginController());
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(charset);
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = url.substring(contextPath.length());
		Controller subController = list.get(path);
		subController.execute(request, response);
		
	}

}
