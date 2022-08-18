package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Member;

public class MemberDao implements IMemberDao {
	//로그인
	@Override
	public Member selectMemberLogin(Connection conn, Member paramMember) throws SQLException {
		//
		System.out.println(paramMember+"<--Dao/paramMember");
		String sql = MemberQuery.SELECT_MEMBER_LOGIN;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, paramMember.getMemberId());
			stmt.setString(2, paramMember.getMemberPw());
			rs = stmt.executeQuery();

			while (rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("memberId"));
				member.setMemberPw(rs.getString("memberPw"));
				//
				System.out.println(member+"<--Dao/member");
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return member;
	}
	//회원가입
	@Override
	public int insertMember(Connection conn, Member paramMember) throws SQLException {
		//
		System.out.println(paramMember+"<--Dao/paramMember");
		int row=0;
		String sql = MemberQuery.INSERT_MEMBER;
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,paramMember.getMemberId());
			stmt.setString(2,paramMember.getMemberPw());
			row =stmt.executeUpdate();
				
		}finally {
			if(stmt!=null) {
				stmt.close();
			}
		}
		
		return row;
	}
	

}
