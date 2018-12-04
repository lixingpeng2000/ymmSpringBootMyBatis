package com.lxp.dao;

import java.sql.SQLException;

import com.lxp.entity.EmployEntity;

public interface IEmpDAO {
	//数据库创建方法
	public boolean doCreate(EmployEntity vo) throws SQLException;
	//数据库删除方法
	public int doRemove(String id) throws SQLException;
	//通过id查找
	public EmployEntity findByid(int id) throws SQLException;
	//public boolean findByTel(String tel,String jname,String jcity) throws SQLException;
	public Object findByTel(EmployEntity vo) throws SQLException;

}
