package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignDao implements ISignDao {
	public String idCheck(Connection conn, String id) throws SQLException {
      String ckId = null;
      //
      System.out.println(id + "<--SignDao/id");
      
      String sql = "SELECT member_id memberId FROM member WHERE member_id = ?";
      PreparedStatement stmt = null;
      ResultSet rs = null;
      try {
    	  stmt=conn.prepareStatement(sql);
    	  stmt.setString(1,id);
    	  rs = stmt.executeQuery();
    	  if(rs.next()) {
    		  ckId=rs.getString("id");
    	  }
      }finally {
    	  if(rs!=null) {
    		  rs.close();
    	  }
    	  if(stmt!=null) {
    		  stmt.close();
    	  }
      }
   
      return ckId;
   }
}