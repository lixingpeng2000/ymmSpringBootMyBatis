package com.lxp.service;

import java.sql.SQLException;

import com.lxp.entity.EmployEntity;

public interface IEmpService {
	//�������ݿ�����Ӳ���
	public boolean insert(EmployEntity vo) throws SQLException;
	//�������ݿ�ɾ������
	public boolean delete(int id);
	public boolean deleteEmployById(String id) throws SQLException;
	public boolean findBytel(String tel,String jname,String jcity) throws SQLException;

}
