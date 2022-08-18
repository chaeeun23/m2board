package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IMemberService;
import service.MemberService;
import vo.Member;

@WebServlet("/addMember")
public class AddMemberController extends HttpServlet {
	private IMemberService memberService;
	//insertMember Form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/view/insertMember.jsp").forward(request, response);
			
	}

	//insertMember Action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//
		System.out.println(id+"<--controller/id");
	
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberPw(pw);
		
		memberService = new MemberService();
		memberService.addMember(member);
		
		response.sendRedirect(request.getContextPath() + "/login");
		
	}

}
