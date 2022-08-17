package repository;

public class BoardQuery {
	public static final String SELECT_BOARD_LIST_BY_PAGE = "SELECT board_no boardNo, title FROM board ORDER BY board_no ASC LIMIT ?,?";
	public static final String SELECT_BOARD_CNT="SELECT COUNT(*) cnt FROM board";
	public static final String SECLET_BOARD_ONE="SELECT board_no boardNo, title, writer, createDate createDate, views, nice FROM board WHERE board_no = ?";
	
					
}
