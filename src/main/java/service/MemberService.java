package service;

import java.sql.Connection;
import java.sql.SQLException;

import commons.DBUtil;
import repository.IMemberDao;
import repository.MemberDao;
import vo.Member;

public class MemberService implements IMemberService {
	private IMemberDao memberDao;
	// 로그인
	@Override
	public Member getMemberLogin(Member paramMember) {
		//
		System.out.println(paramMember + "<--service/paramMember");
		Connection conn = null;
		Member member = null;
		MemberDao memberDao = null;
		try {
			conn = new DBUtil().getConnection();
			conn.setAutoCommit(false);
			member = new Member();
			memberDao = new MemberDao();
			member = memberDao.selectMemberLogin(conn, paramMember);
			//
			System.out.println(member);

			if (member == null) {
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
		return member;
	}

	// 회원가입
	@Override
	public int addMember(Member paramMember) {
		int row=0;
		Connection conn = null;
		try {
			conn=new DBUtil().getConnection();
			conn.setAutoCommit(false);
			memberDao=new MemberDao();
			
			row=memberDao.insertMember(conn, paramMember);
			
			if(row==0) {
				throw new Exception();
			}
			
			conn.commit();
		}catch (Exception e) {
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
		return row;
	}

}
