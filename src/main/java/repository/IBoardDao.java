package repository;

import java.sql.Connection;
import java.util.List;

import vo.Board;
import vo.Nice;

public interface IBoardDao {
	//상품리스트
	List<Board> selectBoardListByPage(Connection conn, int rowPerPage, int beginRow) throws Exception; 
	//페이징
	int selectBoardCnt(Connection conn, int rowPerPage) throws Exception; 
	//상세보기
	List<Board> selectBoardOne(Connection conn, int boardNo) throws Exception; 
	//글쓰기
	int insertBoard(Connection conn, Board board) throws Exception;
	//조회수
	int updateViewsCnt(Connection conn, int BoardNo) throws Exception;
	//좋아요
	int updateNice(Connection conn, Nice nice) throws Exception;
}
