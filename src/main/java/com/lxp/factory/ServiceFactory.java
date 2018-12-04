package com.lxp.factory;

import java.sql.Connection;

import com.lxp.dao.IEmpDAO;
import com.lxp.service.IEmpService;
import com.lxp.service.IJobService;
import com.lxp.service.IUserService;
import com.lxp.service.impl.EmpServiceImpl;
import com.lxp.service.impl.JobServiceImpl;
import com.lxp.service.impl.UserServiceImpl;

public class ServiceFactory {
	//����������ã����ض�Ӧ��ҵ���ʵ��
	public static IEmpService getIEmpServiceIstance(){
		return new EmpServiceImpl();
		
	}

	public static IUserService getIUserServiceIstance() {
		// TODO Auto-generated method stub
		return new UserServiceImpl();
	}

	public static IJobService getIJobServiceIstance() {
		// TODO Auto-generated method stub
		return new JobServiceImpl();
	}
}
