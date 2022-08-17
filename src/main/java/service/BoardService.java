package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commons.DBUtil;
import repository.BoardDao;
import repository.IBoardDao;
import vo.Board;

public class BoardService implements IBoardService {
	private IBoardDao boardDao;

	@Override
	public Map<String, Object> getBoardList(int rowPerPage, int currentPage) {
		Map<String, Object> map = new HashMap<>();
		List<Board> list = new ArrayList<>();
		Connection conn = null;
		int lastPage = 0;
		int totalCount = 0;
		int beginRow = 0;

		try {
			conn = new DBUtil().getConnection();
			this.boardDao = new BoardDao();
			conn.setAutoCommit(false);

			// 페이징
			totalCount = boardDao.selectBoardCnt(conn);
			beginRow = (currentPage - 1) * rowPerPage;
			if (totalCount == 0) {
				throw new Exception();
			}
			lastPage = totalCount / rowPerPage;
			if (totalCount % rowPerPage != 0) {
				lastPage += 1;
			}

			list = boardDao.selectBoardListByPage(conn, rowPerPage, beginRow);

			if (list == null) {
				throw new Exception();
			} else {
				map.put("lastPage", lastPage);
				map.put("list", list);
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return map;
	}
}