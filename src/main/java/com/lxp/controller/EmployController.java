package com.lxp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lxp.entity.EmployEntity;
import com.lxp.factory.ServiceFactory;

@RestController
@RequestMapping("/employ")
public class EmployController {
	@RequestMapping(method = RequestMethod.POST)
	public String postEmploy(HttpServletRequest req) throws UnsupportedEncodingException, IOException{
		System.out.println("命中employ接口的post方法....");
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
		String newStr = params.substring(1, params.length() - 1);
		String[] sourceStrArray = newStr.split(",");
		String data[] = new String[5];
		String[] strdata = new String[5];
		for (int i = 0; i < 5; i++) {
			strdata = sourceStrArray[i].split(":");
			data[i] = strdata[1];
		}
		String name = data[0].substring(1, data[0].length() - 1);
		String tel = data[1].substring(1, data[1].length() - 1);
		;
		String mail = data[2].substring(1, data[2].length() - 1);
		String jname = data[3].substring(1, data[3].length() - 1);
		String jcity = data[4].substring(1, data[4].length() - 1);
		System.out.println("#######&&&&&&&&&&&&&");
		System.out.println("name:" + name + ",tel:" + tel + ",mail:" + mail + ",jname:" + jname + ",jcity:" + jcity);
		EmployEntity emp = new EmployEntity();
		emp.setEname(name);
		emp.setTel(tel);
		emp.setMail(mail);
		emp.setJname(jname);
		emp.setJcity(jcity);
		try {
			if (ServiceFactory.getIEmpServiceIstance().findBytel(tel,jname,jcity)) {
				return "{\"resultCode\":\"501\"}";
			} else {
				try {
					if (ServiceFactory.getIEmpServiceIstance().insert(emp)) {
						return "{\"resultCode\":\"200\"}";
					} else {
						return "{\"resultCode\":\"500\"}";
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

}
