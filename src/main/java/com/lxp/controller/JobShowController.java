package com.lxp.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lxp.entity.JobEntity;
import com.lxp.factory.ServiceFactory;

@RestController
@RequestMapping("/jobshow")
public class JobShowController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getjobshow(){
		System.out.println("命中jobshow接口的get方法...");
		try {
			if (null != ServiceFactory.getIJobServiceIstance().findJobAllList()) {
				List cityList = ServiceFactory.getIJobServiceIstance().findJobAllList();
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
	public String removejobshow(@RequestParam("id") String id){
		System.out.println("命中jobshow接口的delete方法...");
		System.out.println(id);
		try {
			if (!ServiceFactory.getIJobServiceIstance().deleteJobById(id)) {
				ServiceFactory.getIJobServiceIstance().deleteJobById(id);
				System.out.println(ServiceFactory.getIJobServiceIstance().deleteJobById(id));
				System.out.println("{\"resultCode\":\"200\"}");
				return "{\"resultCode\":\"200\"}";
			} else {
				return "{\"resultCode\":\"500\"}";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public String updatejobshow(JobEntity job){
		System.out.println("命中jobshow接口的put方法...");
		System.out.println(job);
		return null;
		
	}
}
