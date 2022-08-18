package repository;

import java.sql.Connection;
import java.sql.SQLException;

public interface ISignDao {
	 String idCheck(Connection conn, String id) throws SQLException;
}
