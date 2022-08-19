package repository;

public class MemberQuery {
	public static final String SELECT_MEMBER_LOGIN="SELECT member_id memberId, member_pw memberPw FROM member WHERE member_id=? AND member_pw=password(?)";
	public static final String INSERT_MEMBER="INSERT INTO member (member_id, member_pw, member_address, member_detail_address) VALUES (?,PASSWORD(?),?,?)";
}
