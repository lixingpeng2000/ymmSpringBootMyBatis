package com.lxp.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lxp.factory.ServiceFactory;

@RestController
@RequestMapping("/jobBrief")
public class JobBriefController {
	@RequestMapping(method = RequestMethod.GET)
	public String getJobBrief(@RequestParam("jcity") String jcity,@RequestParam("jname") String jname){
		System.out.println("命中jobBrief接口的get方法...");
		System.out.println(jcity);
		System.out.println(jname);
		try {
			if (null != ServiceFactory.getIJobServiceIstance().findByJnameandCityList(jname,jcity)) {
				List cityList = ServiceFactory.getIJobServiceIstance().findByJnameandCityList(jname,jcity);
				String objjsonlist = JSON.toJSONString(cityList, true);
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
