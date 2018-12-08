package com.JDBC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.JDBC.DBUtil.DBUtil;
import com.mysql.cj.jdbc.CallableStatement;

public class StudentDAOImplusingCall implements StudentDAO {

	private static final String INSERT = "{CALL updatestudentbyname(?,?)}";

	public void createStudent() {
		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(INSERT)) {
java.sql.CallableStatement cs=con.prepareCall(INSERT);
cs.setString(1, "john@gmail.com");
cs.setString(2, "John");
cs.addBatch();

cs.setString(1, "schweizner@gmail.com");
cs.setString(2, "Mike");
cs.addBatch();

cs.setString(1, "googl@gmail.com");
cs.setString(2, "rodeo");
cs.addBatch();

int[] update=cs.executeBatch();
for(int i:update) {
	System.out.println(i);
}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public Student getStudentById(int studentId) {
		Student s = new Student();

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(" ")) {

			ps.setInt(1, studentId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String subject = rs.getString("subject");
				String year = rs.getString("year");
				s.setEmail(email);
				s.setName(name);
				s.setSubject(subject);
				s.setYear(year);

				System.out.println("Details are :\t" + name + "\t" + email + "\t" + subject + "\t" + year);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	return s;

	}

	@Override
	public void updateStudentByEmail(String newEmail, Integer studentId) {

	}

	@Override
	public void deleteStudent(int studentId) {

	}

	@Override
	public List<Student> getAllStudents() {
		return null;
	}

	@Override
	public void createStudent(Student s) {
		// TODO Auto-generated method stub
		
	}

}
