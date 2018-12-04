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
import com.lxp.entity.EmployEntity;
import com.lxp.service.IEmpService;

public class EmpServiceImpl implements IEmpService {
	private SqlSession session = null;

	public EmpServiceImpl() {
		String resource = "conf.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2������sessionFactory��Ŀ��������session
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		this.session = sessionFactory.openSession(true);
	}

	public boolean insert(EmployEntity vo) throws SQLException {
		// �ܸ��ӵ�ҵ�����
		System.out.println("����ҵ���..insert");
		IEmpDAO dao = session.getMapper(IEmpDAO.class);// �����ݿ����Ӵ���dao��
		return dao.doCreate(vo);
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteEmployById(String id) throws SQLException {
		System.out.println("����ҵ���..deleteEmployById");
		IEmpDAO dao = session.getMapper(IEmpDAO.class);// �����ݿ����Ӵ���dao��
		if(dao.doRemove(id)>0){
			return true;
		}else{
			return false;
		}
		
	}

	public boolean findBytel(String tel, String jname, String jcity) throws SQLException {
		System.out.println("����ҵ���..findBytel");
		EmployEntity emp = new EmployEntity();
		emp.setTel(tel);
		emp.setJname(jname);
		emp.setJcity(jcity);
		// �ܸ��ӵ�ҵ�����
		IEmpDAO dao = session.getMapper(IEmpDAO.class);// �����ݿ����Ӵ���dao��
		if(null == dao.findByTel(emp)){
			return false;
		}else{
			return true;
		}
	}

}
