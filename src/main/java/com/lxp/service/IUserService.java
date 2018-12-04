package com.lxp.service;

import java.sql.SQLException;

import com.lxp.entity.EmployEntity;
import com.lxp.entity.UserEntity;

public interface IUserService {
		//调用数据库的增加操作
		public boolean insert(UserEntity user) throws SQLException;
		//调用数据库删除操作
		public boolean delete(int id);
		
		//调用数据库的查询操作
		public UserEntity find(UserEntity user) throws SQLException;
		public UserEntity findBycity() throws SQLException;
}
