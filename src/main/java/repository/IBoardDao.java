package repository;

import java.sql.Connection;
import java.util.List;

import vo.Board;

public interface IBoardDao {
	List<Board> selectBoardListByPage(Connection conn, int rowPerPage, int beginRow) throws Exception;
	int selectBoardCnt(Connection conn) throws Exception;
	
}
