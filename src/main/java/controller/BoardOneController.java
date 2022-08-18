package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import service.IBoardService;
import vo.Board;

@WebServlet("/boardOne")
public class BoardOneController extends HttpServlet {
	private IBoardService boardService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 요청을 받아 분석
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int views = Integer.parseInt(request.getParameter("views"));
		//
		System.out.print(boardNo);
		// 2.
		boardService = new BoardService();
		List<Board> list = boardService.getBoardOne(boardNo);
		System.out.println(list+"<--controller");
		request.setAttribute("list", list);
		boardService.modifyViews(views, boardNo);

		// 3) 뷰 포워딩
		request.getRequestDispatcher("/WEB-INF/view/boardOne.jsp").forward(request, response);
	}

}
