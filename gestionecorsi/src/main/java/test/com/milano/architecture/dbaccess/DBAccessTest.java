package test.com.milano.architecture.dbaccess;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.milano.architecture.dbaccess.DBAccess;

class DBAccessTest {

	@Test
	void testConnection() {
		try {
			DBAccess.getConnection();
		} catch(SQLException| ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		} finally {
			try {
				DBAccess.closeConnection();
			} catch (SQLException exc) {
				exc.printStackTrace();
				fail(exc.getMessage());
			}
		}
	}

}
