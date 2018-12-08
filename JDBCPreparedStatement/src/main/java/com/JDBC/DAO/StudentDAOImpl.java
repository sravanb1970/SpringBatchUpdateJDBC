package com.JDBC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.JDBC.DBUtil.DBUtil;

public class StudentDAOImpl implements StudentDAO {

	private static final String INSERT = "INSERT INTO MBASTUDENT(NAME, EMAIL, SUBJECT, YEAR) VALUES(?,?,?,?)";
	private static final String SELECT = "SELECT * FROM MBASTUDENT WHERE ID=?";

	@Override
	public void createStudent(Student s) {
		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(INSERT)) {
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getSubject());
			ps.setString(4, s.getYear());
			int update = ps.executeUpdate();
			if (update == 1) {
				System.out.println("Student Details inserted successfully");
			} else {
				System.out.println("error occured");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public Student getStudentById(int studentId) {
		Student s = new Student();

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(SELECT)) {

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

}
