package service;

import java.util.List;
import java.util.Map;

import vo.Board;

public interface IBoardService {
	// 반환값 : List<Board>, int lastPage
	//리스트
	Map<String, Object> getBoardList(int rowPerPage, int currentPage); 
	//상세보기
	List<Board> getBoardOne(int boardNo); 
	//글쓰기
	int addBoard(Board board);
	//조회수
	int modifyViews(int views, int boardNo);
	
}
