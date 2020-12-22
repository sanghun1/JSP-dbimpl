package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.DBConnection;
import model.Dept;

// Data Access Object(데이터에 접근하게 해주는 객체)
public class DeptDao {
	public void 추가(int id) {
		String sql = "INSERT INTO test1(id) VALUES(?)";
		Connection conn = DBConnection.getInstance();
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate(); 
			// 변경된 row count를 리턴 (-1 값은 오류시에만 리턴)
			
			System.out.println("result : " + result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void 삭제(int id) {
		String sql = "DELETE FROM test1 WHERE id = ?";
		Connection conn = DBConnection.getInstance();
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate(); 
			// 변경된 row count를 리턴 (-1 값은 오류시에만 리턴)
			
			System.out.println("result : " + result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void 변경(int id) {
		String sql = "UPDATE test1 SET id = ?";
		Connection conn = DBConnection.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate(); 
			// 변경된 row count를 리턴 (-1 값은 오류시에만 리턴)
			
			System.out.println("result : " + result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Dept 찾기(int deptno) {
		String sql = "SELECT deptno, dname, loc FROM dept WHERE deptno = ?";
		Connection conn = DBConnection.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno); 
			// 변경된 row count를 리턴 (-1 값은 오류시에만 리턴)
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Dept dept = Dept.builder()
					.deptno(rs.getInt("deptno"))
					.dname(rs.getString("dname"))
					.loc(rs.getString("loc"))
					.build();
				System.out.println(dept);
					return dept;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Dept> 전체찾기() {
		String sql = "SELECT deptno, dname, loc FROM dept";
		Connection conn = DBConnection.getInstance();
		List<Dept> deptList = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 변경된 row count를 리턴 (-1 값은 오류시에만 리턴)
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Dept dept = Dept.builder()
					.deptno(rs.getInt("deptno"))
					.dname(rs.getString("dname"))
					.loc(rs.getString("loc"))
					.build();
				System.out.println(dept);
				//deptList.add(dept);
			}
			return deptList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
