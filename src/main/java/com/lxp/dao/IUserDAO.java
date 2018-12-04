package com.lxp.dao;

import java.sql.SQLException;

import com.lxp.entity.EmployEntity;
import com.lxp.entity.UserEntity;

public interface IUserDAO {
	//数据库创建方法
	public int doCreate(UserEntity user) throws SQLException;
	//数据库删除方法
	public boolean doRemove(int id);
	//通过id查找
	public UserEntity findByid(int id);
	public UserEntity doFind(UserEntity user) throws SQLException;

}
