package com.lxp.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lxp.dao.IJobDAO;
import com.lxp.dao.IUserDAO;
import com.lxp.entity.JobEntity;
import com.lxp.service.IJobService;

public class JobServiceImpl implements IJobService {
	private SqlSession session = null;

	public JobServiceImpl() {// ���þ�̬������ͳһ�Ĵ���
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

	public boolean insert(JobEntity job) throws SQLException {
		System.out.println("���븴�ӵ�ҵ���...insert...");
		// �ܸ��ӵ�ҵ�����
		IJobDAO dao = session.getMapper(IJobDAO.class);
		System.out.println("job��"+job);
		if(dao.doCreate(job)>0){
			return true;
		}else {
			return false;
		}
		
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public JobEntity find(JobEntity job) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List findBycity() throws SQLException {
		System.out.println("����getBycity�ĸ��ӵ�ҵ���...findBycity����....");
		// 3��ͨ��session��ȡdao�ӿڶ���
		IJobDAO dao = session.getMapper(IJobDAO.class);
		System.out.println("����������MyBatis...");
		return dao.findByCity();
	}

	public List findBycityList(String city) throws SQLException {
		// 3��ͨ��session��ȡdao�ӿڶ���
		IJobDAO dao = session.getMapper(IJobDAO.class);
		System.out.println("����������MyBatis...findBycityList...");
		return dao.findByCityList(city);
	}

	public List findJobClassList() throws SQLException {
		IJobDAO dao = session.getMapper(IJobDAO.class);
		System.out.println("����������MyBatis...findJobClassList...");
		return dao.findJobClassList();
	}

	public List findJobDeptList() throws SQLException {
		IJobDAO dao = session.getMapper(IJobDAO.class);
		System.out.println("����������MyBatis...findJobDeptList...");
		return dao.findJobDeptList();
	}

	public List findByJnameList(String jKeyword, String city) throws SQLException {
		IJobDAO dao = session.getMapper(IJobDAO.class);
		System.out.println("����������MyBatis...findByJnameList...");
		JobEntity job=new JobEntity();
		String kw="%"+jKeyword+"%";
		job.setJcity(city);
		job.setJname(kw);
		return dao.findJobNameList(job);
	}

	public List findByCityandJclassList(String city, String jclass) throws SQLException {
		IJobDAO dao = session.getMapper(IJobDAO.class);
		System.out.println("����������MyBatis...findByCityandJclassList...");
		JobEntity job=new JobEntity();
		job.setJcity(city);
		job.setJclass(jclass);
		return dao.findByCityandJclassList(job);
	}

	public List findByCityandDeptList(String city, String dept) throws SQLException {
		IJobDAO dao = session.getMapper(IJobDAO.class);
		System.out.println("����������MyBatis...findByCityandDeptList...");
		JobEntity job=new JobEntity();
		job.setJcity(city);
		job.setDept(dept);
		return dao.findByCityandDeptList(job);
	}

	public List findBySelectAllList(String city, String jclass, String dept) throws SQLException {
		IJobDAO dao = session.getMapper(IJobDAO.class);
		System.out.println("����������MyBatis...findBySelectAllList...");
		JobEntity job=new JobEntity();
		job.setJcity(city);
		job.setJclass(jclass);
		job.setDept(dept);
		return dao.findBySelectAllList(job);
	}

	public List findByJnameandCityList(String jname, String city) throws SQLException {
		IJobDAO dao = session.getMapper(IJobDAO.class);
		System.out.println("����������MyBatis...findByJnameandCityList...");
		JobEntity job=new JobEntity();
		job.setJname(jname);
		job.setJcity(city);
		return dao.findByJnameandCityList(job);
	}

	public List findJobAllList() throws SQLException {
		IJobDAO dao = session.getMapper(IJobDAO.class);
		System.out.println("����������MyBatis...findJobAllList...");
		return dao.findJobAllList();
	}

	public boolean deleteJobById(String id) throws SQLException {
		IJobDAO dao = session.getMapper(IJobDAO.class);
		System.out.println("����������MyBatis...deleteJobById...");
		if(dao.deleteJobById(id)>1){
			return true;
		}else {
			return false;
		}
		
	}

	public boolean update(JobEntity job) throws SQLException {
		IJobDAO dao = session.getMapper(IJobDAO.class);
		System.out.println("����������MyBatis...update...");
		System.out.println("job:"+job);
		System.out.println("Ӱ������:"+dao.update(job));
		if(dao.update(job)>0){
			return true;
		}else{
			return false;
		}
	}

	public List findEmployJobList() throws SQLException {
		IJobDAO dao = session.getMapper(IJobDAO.class);
		System.out.println("����������MyBatis...findEmployJobList...");
		return dao.findEmployJobList();
	}

	public List findByALLConditionerList(String jname, String jcity, String dept, String jclass, String nature)
			throws SQLException {
		IJobDAO dao = session.getMapper(IJobDAO.class);
		System.out.println("����"+jcity+"**"+jname+"**"+dept+"**"+jclass+"**"+nature);
		System.out.println("����������MyBatis...findByALLConditionerList..");
		JobEntity job=new JobEntity();
		job.setJcity(jcity);
		job.setJname(jname);
		job.setDept(dept);
		job.setJclass(jclass);
		job.setNature(nature);
		return dao.findByALLConditionerList(job);
	}

	
}
