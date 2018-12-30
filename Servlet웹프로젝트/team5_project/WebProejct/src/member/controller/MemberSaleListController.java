package member.controller;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import member.service.MemberService;
import member.vo.MemberVO;

public class MemberSaleListController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberService service = MemberService.getInstance();
		ArrayList<MemberVO> list = service.memberSaleList();
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "/result/list.jsp");
	}
}
