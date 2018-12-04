package com.lxp.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.lxp.entity.JobEntity;
import com.lxp.entity.UserEntity;

public interface IJobService {
	//调用数据库的增加操作
	public boolean insert(JobEntity job) throws SQLException;
	//调用数据库删除操作
	public boolean delete(int id);
			
	//调用数据库的查询操作
	public JobEntity find(JobEntity job) throws SQLException;
	public List findBycity() throws SQLException;
	public List findBycityList(String city) throws SQLException;
	public List findJobClassList() throws SQLException;
	public List findJobDeptList()throws SQLException;
	public List findByJnameList(String jKeyword,String city) throws SQLException;
	public List findByCityandJclassList(String city,String jclass) throws SQLException;
	public List findByCityandDeptList(String city, String dept) throws SQLException;
	public List findBySelectAllList(String city, String jclass, String dept) throws SQLException;
	public List findByJnameandCityList(String jname, String city) throws SQLException;
	public List findJobAllList() throws SQLException;
	public boolean deleteJobById(String id) throws SQLException;
	public boolean update(JobEntity job) throws SQLException;
	public List findEmployJobList() throws SQLException;
	public List findByALLConditionerList(String jname, String city, String dept, String jclass, String nature) throws SQLException;

}
