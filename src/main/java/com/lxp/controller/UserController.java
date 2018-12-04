package com.lxp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lxp.entity.UserEntity;
import com.lxp.factory.ServiceFactory;

@RestController
@RequestMapping("/user")
public class UserController {
	@RequestMapping(method = RequestMethod.POST)
	public String postUser(HttpServletRequest req) throws UnsupportedEncodingException, IOException {
		System.out.println("user接口的post方法....");
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
		String data[] = new String[2];
		String[] strdata = new String[2];
		for (int i = 0; i < 2; i++) {
			strdata = sourceStrArray[i].split(":");
			data[i] = strdata[1];
		}
		String username = data[0];
		String pwd = data[1];
		System.out.println("username:" + username + ",pwd:" + pwd);
		UserEntity user = new UserEntity();
		user.setUsername(username.substring(1,username.length()-1));
		user.setPwd(pwd.substring(1,pwd.length()-1));
		try {
			if (ServiceFactory.getIUserServiceIstance().insert(user)) {
				return "{\"resultCode\":\"200\"}";
			} else {
				return "{\"resultCode\":\"500\"}";
			}
		} catch (SQLException e) {

		}
		return null;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getUser(UserEntity user,HttpServletRequest req){
		System.out.println("命中user接口的get方法...");
		String username = user.getUsername();
		String pwd = user.getPwd();
		System.out.println("获取到的用户名和密码:"+username+":"+pwd);
		try {
			System.out.println(ServiceFactory.getIUserServiceIstance().find(user));
			if (null != ServiceFactory.getIUserServiceIstance().find(user)) {
				UserEntity us=ServiceFactory.getIUserServiceIstance().find(user);
				HttpSession session=req.getSession();
				session.setAttribute("username",username);
				session.setAttribute("pwd",pwd);
				String usernameSes=session.getAttribute("username").toString();
				System.out.println(usernameSes);
				System.out.println("{\"resultCode\":\"200\""+",\"username\":\""+us.getUsername()+"\",\"pwd\":\""+us.getPwd()+"\"}");
				return "{\"resultCode\":\"200\""+",\"username\":\""+us.getUsername()+"\",\"pwd\":\""+us.getPwd()+"\"}";		
			} else {
				return "{\"resultCode\":\"500\"}";
			}
		} catch (SQLException e) {

		}
		return null;
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public String doDelete(@RequestParam("username") String username,HttpServletRequest req){
		System.out.println("命中user的dodelete方法....");
		System.out.println(username);
		HttpSession session=req.getSession();
		session.removeAttribute("username");
		return "{\"resultCode\":\"200\"}";
		
	}
}
