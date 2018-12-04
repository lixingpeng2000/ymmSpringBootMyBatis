package com.lxp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lxp.entity.JobCityEntity;
import com.lxp.entity.JobEntity;
import com.lxp.factory.ServiceFactory;

@RestController
@RequestMapping("/job")
public class JobController {

	@RequestMapping(method = RequestMethod.GET)
	public String getJob() {
		System.out.println("测试方法命中此方法.....");
		try {
			if (null != ServiceFactory.getIJobServiceIstance().findBycity()) {
				List cityList = ServiceFactory.getIJobServiceIstance().findBycity();
				JobCityEntity jcentity = null;
				String[] str = new String[2];
				for (int x = 0; x < cityList.size(); x++) {
					jcentity = (JobCityEntity) cityList.get(x);
					System.out.println(jcentity.getJcity() + "," + jcentity.getJnum());
					str[x] = "{\"jcity\":\"" + jcentity.getJcity() + "\",\"jobnum\":\"" + jcentity.getJnum() + "\"}";
					System.out.println(
							"{\"jcity\":\"" + jcentity.getJcity() + "\",\"jobnum\":\"" + jcentity.getJnum() + "\"}");
					String objjson = JSON.toJSONString(jcentity);
				}
				String objjsonlist = JSON.toJSONString(cityList, true);
				System.out.println("{\"resultCode\":\"200\"" + ",\"data\":" + objjsonlist + "}");
				return "{\"resultCode\":\"200\"" + ",\"data\":" + objjsonlist + "}";

			} else {
				System.out.println("请求失败.....");
				return "{\"resultCode\":\"500\"}";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping(method = RequestMethod.POST)
	public String createJob(HttpServletRequest req) throws UnsupportedEncodingException, IOException {
		System.out.println("命中job接口的post方法");
		BufferedReader br = new BufferedReader(
				new InputStreamReader((ServletInputStream) req.getInputStream(), "utf-8"));
		StringBuffer sb = new StringBuffer("");
		String temp;
		while ((temp = br.readLine()) != null) {
			sb.append(temp);
		}
		br.close();
		String params = sb.toString();
		System.out.println(params);
		JobEntity je = (JobEntity) JSON.parseObject(params,JobEntity.class);
       	String jobName = je.getJname();
		String city = je.getJcity();
		String dept = je.getDept();
		String jobClass = je.getJclass();
		String initduty = je.getDuty();
		String initrequire = je.getReq();
		String nature = je.getNature();
		String duty = initduty.replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
		String require = initrequire.replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
		JobEntity job=new JobEntity(jobName,city,dept,jobClass,duty,require,nature);
		System.out.println("jobName:" + jobName + ",city:" + city + ",dept:" + dept + ",jobClass:" + jobClass + ",duty:"
				+ duty + ",nature:" + nature);
		try {
			if (ServiceFactory.getIJobServiceIstance().findByALLConditionerList(jobName, city, dept, jobClass, nature)
					.size() != 0) {
				return "{\"resultCode\":\"204\"}";
			} else {
				if (ServiceFactory.getIJobServiceIstance().insert(job)) {
					return "{\"resultCode\":\"200\"}";
				} else {
					return "{\"resultCode\":\"500\"}";
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
}
