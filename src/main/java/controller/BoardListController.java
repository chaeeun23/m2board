package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import service.IBoardService;

@WebServlet("/boardList")
public class BoardListController extends HttpServlet {
	private IBoardService boardService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//컨트롤러
		//1) 요청을 받아 분석 
		final int  ROW_PER_PAGE = 10;
		
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		//2) 서비스 레이어를 요청(메서드 요청) -> 모델값(자료구조) 구하기 위함
		//new
		boardService = new BoardService();
		Map<String, Object> map = boardService.getBoardList(ROW_PER_PAGE, currentPage);
		request.setAttribute("lastPage", map.get("lastPage"));
		request.setAttribute("list", map.get("list"));
		//
		System.out.println(map.get("list") +"<-- listController");
		request.setAttribute("currentPage", currentPage);
		
		//3) 뷰 포워딩
		request.getRequestDispatcher("/WEB-INF/view/boardList.jsp").forward(request, response);
	}

	

}
