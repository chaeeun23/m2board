package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Board;

public class BoardDao implements IBoardDao {

	@Override
	public List<Board> selectBoardListByPage(Connection conn, int rowPerPage, int beginRow) throws Exception {
		List<Board> list = new ArrayList<Board>();
		String sql = BoardQuery.SELECT_BOARD_LIST_BY_PAGE; //쿼리가져오기
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setBoardNo(rs.getInt("boardNo"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setCreateDate(rs.getString("createDate"));
				board.setRead(rs.getInt("read"));
				board.setNice(rs.getInt("nice"));
				list.add(board);	
			}
		}finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		
		return list;
	}

	@Override
	public int selectBoardCnt(Connection conn) throws Exception {
		int row=0;
		int totalCount = 0;
		String sql = BoardQuery.SELECT_BOARD_CNT; //쿼리가져오기
		PreparedStatement stmt=null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				totalCount = rs.getInt("cnt");
			}
		}finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return row;
	}

}
