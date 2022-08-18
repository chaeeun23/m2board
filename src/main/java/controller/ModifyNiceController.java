package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import service.IBoardService;
import vo.Member;
import vo.Nice;

@WebServlet("/modifyNice")
public class ModifyNiceController extends HttpServlet {
	private IBoardService boardService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boardService = new BoardService();
		Member member = new Member();
		Nice nice = new Nice();
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") == null) { 
			response.sendRedirect(request.getContextPath()+ "/login");
			return;
		}
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int views = Integer.parseInt(request.getParameter("views"));
//
		System.out.println(boardNo+" <--controller/boardNo");
		
		member = (Member)session.getAttribute("loginMember");
		//
		System.out.println(member+" <--Nicecontroller/member");
		String memberId = member.getMemberId();
		
		nice.setMemberId(memberId);
		nice.setBoardNo(boardNo);
		this.boardService.modifyNice(nice);
		
		response.sendRedirect(request.getContextPath() + "/boardOne?boardNo="+boardNo+"&views="+views);
	}
}
