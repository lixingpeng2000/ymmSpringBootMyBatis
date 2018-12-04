package com.lxp.dao;

import java.sql.SQLException;

import com.lxp.entity.EmployEntity;
import com.lxp.entity.UserEntity;

public interface IUserDAO {
	//���ݿⴴ������
	public int doCreate(UserEntity user) throws SQLException;
	//���ݿ�ɾ������
	public boolean doRemove(int id);
	//ͨ��id����
	public UserEntity findByid(int id);
	public UserEntity doFind(UserEntity user) throws SQLException;

}
