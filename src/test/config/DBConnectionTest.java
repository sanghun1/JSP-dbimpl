package test.config;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Test;

import config.DBConnection;

public class DBConnectionTest {
	@Test
	public void 데이터베이스연결_테스트() {
		Connection conn = DBConnection.getInstance();
		assertNotNull(conn);
	}
	
	
}
