package org.springexamples.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springexamples.bean.MyEmployee;
import org.springexamples.dao.MyEmployeeDao;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class MyEmployeeDaoImplV2 implements MyEmployeeDao {

	private NamedParameterJdbcTemplate namedParameterjdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	public void setDataSource(DataSource dataSource){
		this.namedParameterjdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
		this.simpleJdbcCall=new SimpleJdbcCall(dataSource);
	}

	@Override
	public void addEmployee(MyEmployee employee) {
		String sql="insert into myemployee(empname,birthdate,joindate,idtype,idno,email,mobileno)"
				+ "values(:name,:bdate,:jdate,:idtype,:idno,:email,:mobileno)";
		Map namedParams=new HashMap();
		namedParams.put("name", employee.getEmpname());
		namedParams.put("bdate", employee.getBirthDate());
		namedParams.put("jdate", employee.getJoinDate());
		namedParams.put("idtype", employee.getIdType());
		namedParams.put("idno", employee.getIdno());
		namedParams.put("email", employee.getEmail());
		namedParams.put("mobileno", employee.getMobileno());
		
		int result=namedParameterjdbcTemplate.update(sql, namedParams);
		if(result > -1){
			System.out.println("Inserted Successfully!!");
		}else{
			System.out.println("Insertion Failed!!");
		}
	}

	@Override
	public void updateEmployee(MyEmployee employee) {
		String sql="update myemployee set empname=:ename,birthdate=:bdate,joindate=:jdate,idtype=:idtype,idno=:idno,email=:email,mobileno=:mobile where empid=:eid";
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("ename", employee.getEmpname());
		namedParameters.addValue("bdate", employee.getBirthDate());
		namedParameters.addValue("jdate", employee.getJoinDate());
		namedParameters.addValue("idtype", employee.getIdType());
		namedParameters.addValue("idno", employee.getIdno());
		namedParameters.addValue("email", employee.getEmail());
		namedParameters.addValue("mobile", employee.getMobileno());
		namedParameters.addValue("eid", employee.getEmpid());
		
		int result=namedParameterjdbcTemplate.update(sql, namedParameters);
		if(result > -1){
			System.out.println("Updated Successfully!!");
		}else{
			System.out.println("Updation Failed!!");
		}
	}

	@Override
	public void deleteEmployee(MyEmployee employee) {
		String sql="delete from myemployee where empid=:eid ";
		SqlParameterSource namedParameters = new MapSqlParameterSource("eid", employee.getEmpid());
		
		int result=namedParameterjdbcTemplate.update(sql, namedParameters);
		if(result > -1){
			System.out.println("Deleted Successfully!!");
		}else{
			System.out.println("Deletion Failed!!");
		}
		
	}

	@Override
	public List<MyEmployee> fetchEmployee() {
		String sql="select * from myemployee";
		SqlParameterSource namedParameters = new MapSqlParameterSource();
		List<MyEmployee> empList=(List<MyEmployee>)namedParameterjdbcTemplate.query(sql,namedParameters,new EmployeeMapper());
		return empList;
	}

	@Override
	public Map<String, Object> getEmployeeUsingStoredProcById(MyEmployee employee) {
		
		simpleJdbcCall.withProcedureName("getEmployeeDetailById");
		
		MapSqlParameterSource in = new MapSqlParameterSource();
		in.addValue("id", employee.getEmpid());
		
		Map result=simpleJdbcCall.execute(in);
		
		return result;
	}

	@Override
	public MyEmployee getEmployeeById(MyEmployee employee) {
		String sql="select * from myemployee where empid=:eid";
		
		SqlParameterSource namedParameters = new MapSqlParameterSource("eid",employee.getEmpid());
		MyEmployee emp=namedParameterjdbcTemplate.queryForObject(sql, namedParameters, new EmployeeMapper());
		return emp;
	}
}
class EmployeeMapper implements RowMapper<MyEmployee>{

	@Override
	public MyEmployee mapRow(ResultSet rs, int arg1) throws SQLException {
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
	
}
