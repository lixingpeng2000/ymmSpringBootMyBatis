package com.lxp.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lxp.factory.ServiceFactory;

@RestController
@RequestMapping("/jobnameSearch")
public class JobSearchController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String jobSearch(@RequestParam("keyword") String jKeyword,@RequestParam("city") String city,@RequestParam("pageNum") String pagenum){
		System.out.println("命中jobnameSearch接口的get方法...");
		System.out.println("获取到的参数是:"+jKeyword+city+pagenum);
		int pageNum = Integer.parseInt(pagenum);
		try {
					if (null != ServiceFactory.getIJobServiceIstance().findByJnameList(jKeyword,city)) {
						List cityList = ServiceFactory.getIJobServiceIstance().findByJnameList(jKeyword,city);
						System.out.println(cityList);
						List newcityList = new ArrayList();
						int lastNum;
						if (cityList.size() % 5 == 0) {
							lastNum = (cityList.size() / 5);
						} else {
							lastNum = (cityList.size() / 5) + 1;
						}

						int lastdatanum = cityList.size() - (lastNum - 1) * 5;
						int pageCount = lastNum;
						if (pageCount == 0) {
							lastdatanum = 0;
						}
						System.out.println("�ܹ�ҳ" + pageCount);
						System.out.println("���һҳ��Ŀ" + lastdatanum);
						String objjsonlist = "";
						if (pageCount == 0) {
							objjsonlist = "";
						} else {
							if (pageNum != lastNum) {// �ж��Ƿ��������һҳ����
								newcityList.add(cityList.get((pageNum - 1) * 5 + 0));
								newcityList.add(cityList.get((pageNum - 1) * 5 + 1));
								newcityList.add(cityList.get((pageNum - 1) * 5 + 2));
								newcityList.add(cityList.get((pageNum - 1) * 5 + 3));
								newcityList.add(cityList.get((pageNum - 1) * 5 + 4));
							} else {
								for (int i = 0; i < lastdatanum; i++) {
									newcityList.add(cityList.get((pageNum - 1) * 5 + i));
								}
							}
							objjsonlist = JSON.toJSONString(newcityList, true);

						}
						System.out.println("{\"resultCode\":\"200\"" + ",\"data\":" + objjsonlist + ",\"pageNum\":"
								+ pageNum + ",\"pageCount\":" + pageCount + "}");
						return "{\"resultCode\":\"200\"" + ",\"data\":" + objjsonlist + ",\"pageNum\":"
								+ pageNum + ",\"pageCount\":" + pageCount + "}";

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
