package com.lxp.service;

import java.sql.SQLException;

import com.lxp.entity.EmployEntity;
import com.lxp.entity.UserEntity;

public interface IUserService {
		//�������ݿ�����Ӳ���
		public boolean insert(UserEntity user) throws SQLException;
		//�������ݿ�ɾ������
		public boolean delete(int id);
		
		//�������ݿ�Ĳ�ѯ����
		public UserEntity find(UserEntity user) throws SQLException;
		public UserEntity findBycity() throws SQLException;
}
