package com.spring.jdbctemplate;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class DBOperationsDAO implements DBOperations{

	private static final String insertQuery="insert into employee values(?,?,?,?,?)";
	
//	private static final String updateQuery="update employee set into employee values(?,?,?,?,?)";
	private static final String selectQuery="select * from employee";
	private static final String selectEmpSalaaryQuery="select * from employee where sal=?";
//	private static final String insertQuery="insert into employee values(?,?,?,?,?)";
	
	private JdbcTemplate jt;
	
	
	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public int insert(Employee e) {
int result=jt.update(insertQuery,e);
		return result;
	}

	public int getSalary(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Map<String, Object> listEmpDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteEmp(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateEmpSalary(int no, int newSal) {
		// TODO Auto-generated method stub
		return 0;
	}

}
