package repository;

import java.sql.Connection;
import java.util.List;

import vo.Board;

public interface IBoardDao {
	List<Board> selectBoardListByPage(Connection conn, int rowPerPage, int beginRow) throws Exception; //상품리스트
	int selectBoardCnt(Connection conn, int rowPerPage) throws Exception; //페이징
	List<Board> selectBoardOne(Connection conn, int boardNo) throws Exception; //상세보기
	
}
