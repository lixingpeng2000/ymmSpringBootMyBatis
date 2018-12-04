package com.lxp.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lxp.entity.JobEntity;
import com.lxp.factory.ServiceFactory;

@RestController
@RequestMapping("/jobInfo")
public class JobInfoController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getJobInfo(JobEntity job){
		System.out.println("命中jobinfo接口的get方法...");
		System.out.println(job);
		String jname=job.getJname();
		String city=job.getJcity();
		String dept = job.getDept();
		String jclass = job.getJclass();
		String nature = job.getNature();
		try {
			if (null != ServiceFactory.getIJobServiceIstance().findByALLConditionerList(jname,city,dept,jclass,nature)) {
				List cityList = (List) ServiceFactory.getIJobServiceIstance().findByALLConditionerList(jname,city,dept,jclass,nature);
				String objjsonlist = JSON.toJSONString(cityList, true);
				System.out.println(objjsonlist);
				System.out.println("{\"resultCode\":\"200\"" + ",\"data\":" + objjsonlist + "}");
				return "{\"resultCode\":\"200\"" + ",\"data\":" + objjsonlist + "}";

			} else {
				return "{\"resultCode\":\"500\"}";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
