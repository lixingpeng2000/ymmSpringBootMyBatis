package com.lxp.service;

import java.sql.SQLException;

import com.lxp.entity.EmployEntity;

public interface IEmpService {
	//调用数据库的增加操作
	public boolean insert(EmployEntity vo) throws SQLException;
	//调用数据库删除操作
	public boolean delete(int id);
	public boolean deleteEmployById(String id) throws SQLException;
	public boolean findBytel(String tel,String jname,String jcity) throws SQLException;

}
