package com.lxp.dao;

import java.sql.SQLException;

import com.lxp.entity.EmployEntity;

public interface IEmpDAO {
	//���ݿⴴ������
	public boolean doCreate(EmployEntity vo) throws SQLException;
	//���ݿ�ɾ������
	public int doRemove(String id) throws SQLException;
	//ͨ��id����
	public EmployEntity findByid(int id) throws SQLException;
	//public boolean findByTel(String tel,String jname,String jcity) throws SQLException;
	public Object findByTel(EmployEntity vo) throws SQLException;

}
