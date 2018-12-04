package com.lxp.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.lxp.entity.JobEntity;
import com.lxp.entity.UserEntity;

public interface IJobDAO {
	//数据库创建方法
	public int doCreate(JobEntity job) throws SQLException;
	//数据库删除方法
	public boolean doRemove(int id);
	//通过id查找
	public JobEntity findByid(int id);
	public JobEntity doFind(JobEntity job) throws SQLException;
	public List findByCity() throws SQLException;
	public List findByCityList(String city) throws SQLException;
	public List findJobClassList() throws SQLException;
	public List findJobDeptList() throws SQLException;
	public List findJobNameList(JobEntity job)throws SQLException;
	//public List findJobNameList(String jname,String city)throws SQLException;
	//public List findByCityandJclassList(String city, String jclass) throws SQLException;
	public List findByCityandJclassList(JobEntity job) throws SQLException;
	//public List findByCityandDeptList(String city, String dept) throws SQLException;
	public List findByCityandDeptList(JobEntity job) throws SQLException;
	public List findBySelectAllList(JobEntity job) throws SQLException;
	//public List findBySelectAllList(String city, String jclass,String dept) throws SQLException;
	public List findByJnameandCityList(JobEntity job) throws SQLException;
	//public List findByJnameandCityList(String city, String jname) throws SQLException;
	//public List findByALLConditionerList(String jcity, String jname,String dept,String jclass,String nature) throws SQLException;
	public List findByALLConditionerList(JobEntity job) throws SQLException;
	public List findJobAllList() throws SQLException;
	public int deleteJobById(String id) throws SQLException;
	public int update(JobEntity job) throws SQLException;
	public List findEmployJobList() throws SQLException;


}
