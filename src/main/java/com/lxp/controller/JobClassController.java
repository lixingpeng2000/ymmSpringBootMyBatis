package com.lxp.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lxp.factory.ServiceFactory;

@RestController
@RequestMapping("/jobClass")
public class JobClassController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getJobClass(){
		System.out.println("命中jobclass的get方法....");
		try {
			if (null != ServiceFactory.getIJobServiceIstance().findJobClassList()) {
				List cityList = ServiceFactory.getIJobServiceIstance().findJobClassList();
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

}
