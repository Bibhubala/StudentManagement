package com.java;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcConn {

	public static Connection getConnection() {
		Connection con = null;
		try {
			System.out.println("INside getconnection  method");
			// load jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Establish connection
			System.out.println("Class load");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "284707");
			System.out.println("connection  establish");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static int getInsertStd(StudentDao a) {
		int result = 0;
		try {
			System.out.println("inside getInserStd");
			Connection con = JdbcConn.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?)");
			System.out.println("after Preparestatement");
			ps.setInt(1, a.getPassword());
			System.out.println("after Preparestatement" + a.getName());
			ps.setString(2, a.getName());
			ps.setString(3, a.getUserName());
			System.out.println("2 :" + a.getUserName());
			result = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static StudentDao getAlStudent(int sno, String sname) {
		StudentDao d = new StudentDao();

		try {
			Connection con = JdbcConn.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM STUDENT WHERE SNO=? AND SNAME=?");
			ps.setInt(1, sno);
			ps.setString(2, sname);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				d.setPassword(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setUserName(rs.getString(3));
			} else {
				System.out.println("else blobk");
				return d = null;
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return d;
	}

	public static List<StudentDao> getStudent() {
		List<StudentDao> sd = new ArrayList<StudentDao>();
		try {
			Connection con = JdbcConn.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM STUDENT");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentDao st = new StudentDao();
				st.setPassword(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setUserName(rs.getString(3));
				sd.add(st);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sd;
	}

}
