package service;

import java.sql.Connection;

import commons.DBUtil;
import repository.SignDao;

public class SignService implements ISignService{
	private SignDao signDao;
	@Override
	public boolean getidCheck(String id) throws Exception {
		boolean result = false;
		SignDao signDao = new SignDao();
		this.signDao = new SignDao();
		
		Connection conn= null;
		try {
			conn=new DBUtil().getConnection();
			conn.setAutoCommit(false);
			
			if(signDao.idCheck(conn, id)==null) {
				result = true;
			}
			conn.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
			conn.rollback();
			
		} finally {
			
			}
		return result;
		}
	} 