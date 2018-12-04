package com.lxp.service.impl;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lxp.dao.IEmpDAO;
import com.lxp.dao.IUserDAO;
import com.lxp.entity.UserEntity;
import com.lxp.service.IUserService;

public class UserServiceImpl implements IUserService {
	private SqlSession session = null;
	public UserServiceImpl(){
		String resource = "conf.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		this.session = sessionFactory.openSession(true);
	}

	public boolean insert(UserEntity user) throws SQLException {
		System.out.println("���븴�ӵ�ҵ���...insert");
		IUserDAO dao = session.getMapper(IUserDAO.class);
		if(dao.doCreate(user)>0){
			return true;
		}else{
			return false;
		}
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public UserEntity find(UserEntity user) throws SQLException {
		System.out.println("���븴�ӵ�ҵ���...find");
		IUserDAO dao = session.getMapper(IUserDAO.class);
		return dao.doFind(user);
	}

	public UserEntity findBycity() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
