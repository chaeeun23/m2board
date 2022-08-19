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
import vo.Nice;

public class BoardService implements IBoardService {
	private IBoardDao boardDao;

	// 리스트
	@Override
	public Map<String, Object> getBoardList(int rowPerPage, int currentPage) {
		Map<String, Object> map = new HashMap<>();
		List<Board> list = new ArrayList<>();
		int beginRow = (currentPage - 1) * rowPerPage;
		Connection conn = null;

		try {
			conn = new DBUtil().getConnection();
			boardDao = new BoardDao();
			conn.setAutoCommit(false);

			// 페이징
			int totalCount = boardDao.selectBoardCnt(conn, rowPerPage);

			if (totalCount == 0) {
				throw new Exception();
			}
			int lastPage = totalCount / rowPerPage;
			if (totalCount % rowPerPage != 0) {
				lastPage += 1;
			}

			list = boardDao.selectBoardListByPage(conn, rowPerPage, beginRow);
			//
			System.out.println(list + "<--service");
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
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return map;
	}

	// 상세보기
	@Override
	public List<Board> getBoardOne(int boardNo) {
		List<Board> list = new ArrayList<Board>();
		Connection conn = null;
		try {
			conn = new DBUtil().getConnection();
			boardDao = new BoardDao();
			conn.setAutoCommit(false);
			list = boardDao.selectBoardOne(conn, boardNo);
			//
			System.out.println(list + "<--service");
			if (list == null) {
				throw new Exception();
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
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return list;
	}

	// 글쓰기
	@Override
	public int addBoard(Board board) {
		int row = 0;
		Connection conn = null;
		try {
			conn = new DBUtil().getConnection();
			boardDao = new BoardDao();
			row = boardDao.insertBoard(conn, board);
			if (row == 0) {
				throw new Exception();
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return row;
	}

	// 조회수
	@Override
	public int modifyViews(int views, int boardNo) {
		int row = 0;
		Connection conn = null;

		try {
			conn = new DBUtil().getConnection();
			conn.setAutoCommit(false);
			boardDao = new BoardDao();

			row = boardDao.updateViewsCnt(conn, boardNo);
			if (row == 0) {
				throw new Exception();
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return row;
	}

	// 좋아요한 사람 인서트
	@Override
	public int modifyNice(Nice nice) {
		int row = 0;
		Connection conn = null;

		try {
			conn = new DBUtil().getConnection();
			conn.setAutoCommit(false);
			boardDao = new BoardDao();
			row = boardDao.updateNice(conn,nice);
			if (row == 0) {
				throw new Exception();
			}

			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return row;
	}

	// 좋아요 수 
	@Override
	public int modifyPlusNice(int boardNo) {
		int row=0;
		Connection conn = null;
		
		try {
			conn=new DBUtil().getConnection();
			conn.setAutoCommit(false);
			boardDao = new BoardDao();
			row=boardDao.updatePlusNice(conn,boardNo);
			if(row==0) {
				throw new Exception();
			}
			conn.commit();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return row;
	}
	
}
