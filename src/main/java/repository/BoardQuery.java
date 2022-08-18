package repository;

public class BoardQuery {
	public static final String SELECT_BOARD_LIST_BY_PAGE = "SELECT board_no boardNo, title, writer, create_date createDate, views, nice FROM board ORDER BY board_no ASC LIMIT ?,?";
	public static final String SELECT_BOARD_CNT="SELECT COUNT(*) cnt FROM board";
	public static final String SECLET_BOARD_ONE="SELECT board_no boardNo, title, writer, create_Date createDate, views, nice FROM board WHERE board_no = ?";
	public static final String INSERT_BOARD="INSERT INTO board(title, writer, create_date) VALUES(?,?,NOW())";
	public static final String UPDATE_VIEWS_CNT	="UPDATE board SET views = views + 1 WHERE board_no = ?";
	public static final String UPDATE_NICE="UPDATE board SET nice = nice + 1 WHERE board_no = ?";			
}
