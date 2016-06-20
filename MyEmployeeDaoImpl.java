package org.springexamples.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springexamples.bean.MyEmployee;
import org.springexamples.dao.MyEmployeeDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MyEmployeeDaoImpl implements MyEmployeeDao {
	
	private JdbcTemplate empJdbcTemplate;

	public JdbcTemplate getEmpJdbcTemplate() {
		return empJdbcTemplate;
	}

	public void setEmpJdbcTemplate(JdbcTemplate empJdbcTemplate) {
		this.empJdbcTemplate = empJdbcTemplate;
	}

	@Override
	public void addEmployee(MyEmployee employee) {
		String sql="INSERT INTO myemployee (empname,birthdate,joindate,idtype,idno,email,mobileno)VALUES (?,?,?,?,?,?,?)";
		
		Object[] args=new Object [] {
				employee.getEmpname(),
				employee.getBirthDate(),
				employee.getJoinDate(),
				employee.getIdType(),
				employee.getIdno(),
				employee.getEmail(),
				employee.getMobileno()
		};
		
		int result=empJdbcTemplate.update(sql, args);
		
		if(result !=0){
			System.out.println("Employee Record Saved Successfully!!");
		}else{
			System.out.println("Err:Record Saving Failure!!");
		}
	}

	@Override
	public void updateEmployee(MyEmployee employee) {
		
		String sql="update myemployee set email=?, mobileno=? where empid=?";
		Object[] args=new Object[]{				
				employee.getEmail(),
				employee.getMobileno(),
				employee.getEmpid()
		};
		
		int result=empJdbcTemplate.update(sql, args);
		
		if(result !=0){
			System.out.println("Employee Record updated Successfully!!");
		}else{
			System.out.println("Err:Record Updating Failure!!");
		}
	}

	@Override
	public void deleteEmployee(MyEmployee employee) {
		String sql="delete from myemployee where empid=?";
		
		Object[] args=new Object[]{
			employee.getEmpid()	
		};
		
		int result=empJdbcTemplate.update(sql, args);
		
		if(result !=0){
			System.out.println("Employee Record deleted Successfully!!");
		}else{
			System.out.println("Err:Record deleting Failure!!");
		}
	}

	@Override
	public List<MyEmployee> fetchEmployee() {
		String sql="select * from myemployee";
		List<MyEmployee> employeeList=empJdbcTemplate.query(sql,new RowMapper<MyEmployee>(){

			@Override
			public MyEmployee mapRow(ResultSet rs, int arg1)throws SQLException {
				MyEmployee employee=new MyEmployee();
				employee.setEmpid(rs.getInt("empid"));
				employee.setEmpname(rs.getString("empname"));
				employee.setBirthDate(rs.getString("birthdate"));
				employee.setJoinDate(rs.getString("joindate"));
				employee.setIdType(rs.getString("idtype"));
				employee.setIdno(rs.getString("idno"));
				employee.setEmail(rs.getString("email"));
				employee.setMobileno(rs.getString("mobileno"));
				return employee;
			}
		});
		return employeeList;
	}
	
	@Override
	public Map<String,Object> getEmployeeUsingStoredProcById(MyEmployee employee) {
		
		SqlParameter InParam_empid=new SqlParameter(Types.BIGINT);
		List<SqlParameter> parameters=new ArrayList<SqlParameter>();
		parameters.add(InParam_empid);
		
		Map<String,Object> empRec=empJdbcTemplate.call(new CallableStatementCreator() {
			
			@Override
			public CallableStatement createCallableStatement(Connection conn)
					throws SQLException {
				CallableStatement callStmnt=conn.prepareCall("{call employeeById(?)}");
				callStmnt.setLong(1, employee.getEmpid());
				
			
				return callStmnt;
			}
		},parameters);
		
		return empRec;
	}

}
