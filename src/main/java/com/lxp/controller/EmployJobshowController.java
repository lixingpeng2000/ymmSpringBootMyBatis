package com.lxp.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lxp.entity.EmpJobEntity;
import com.lxp.factory.ServiceFactory;

@RestController
@RequestMapping("/employJobshow")
public class EmployJobshowController {
	@RequestMapping(method = RequestMethod.GET)
	public String getEmployJobshow(HttpServletRequest req) {
		System.out.println("命中employJobshow接口的get方法");
		try {
			if (null != ServiceFactory.getIJobServiceIstance().findEmployJobList()) {
				List cityList = ServiceFactory.getIJobServiceIstance().findEmployJobList();
				String objjsonlist = JSON.toJSONString(cityList, true);
				System.out.println(objjsonlist);
				System.out.println("{\"resultCode\":\"200\"" + ",\"data\":" + objjsonlist + "}");
				return "{\"resultCode\":\"200\"" + ",\"data\":" + objjsonlist + "}";

			} else {
				return "{\"resultCode\":\"500\"}";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public String deleteEmployJobshow(@RequestParam("id") String id){
		System.out.println("命中jobshow接口的delete方法...");
		System.out.println(id);
		try {
			if (!ServiceFactory.getIEmpServiceIstance().deleteEmployById(id)) {
				ServiceFactory.getIEmpServiceIstance().deleteEmployById(id);
				System.out.println(ServiceFactory.getIEmpServiceIstance().deleteEmployById(id));
				System.out.println("{\"resultCode\":\"200\"}");
				return "{\"resultCode\":\"200\"}";

			} else {
				System.out.println("�ύʧ��");
				return "{\"resultCode\":\"500\"}";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
