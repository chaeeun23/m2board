package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import service.IBoardService;

@WebServlet("/modifyNice")
public class ModifyNiceController extends HttpServlet {
	private IBoardService boardService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boardService = new BoardService();

		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		boardService.modifyNice(boardNo);

		response.sendRedirect(request.getContextPath() + "/boardList");
	}
}
