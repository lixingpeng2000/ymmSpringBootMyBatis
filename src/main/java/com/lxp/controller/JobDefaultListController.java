package com.lxp.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lxp.factory.ServiceFactory;

@RestController
@RequestMapping("/jobDefaultList")
public class JobDefaultListController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getJobList(@RequestParam("city") String city){
		System.out.println("命中jobDefaultList接口的get方法....");
		System.out.println(city);
		try {
			if (null != ServiceFactory.getIJobServiceIstance().findBycityList(city)) {
				List cityList = ServiceFactory.getIJobServiceIstance().findBycityList(city);
				System.out.println(cityList.size());
				String objjson = JSON.toJSONString(cityList, true);
				Iterator it = cityList.iterator();
		        while(it.hasNext()){
		            System.out.println(it.next()); }
				List newCityList=new ArrayList();
				int lastNum=(cityList.size()/5)+1;
				int lastdatanum=cityList.size()-(lastNum-1)*5;
				int pageCount = lastNum;
				System.out.println("lastNum:"+lastNum);
				System.out.println("lastdatanum:"+lastdatanum);
				List newcityList=new ArrayList();
				int pageNum = 1;
				if(pageNum != lastNum){//�ж��Ƿ��������һҳ����
					newcityList.add(cityList.get((pageNum-1)*5+0));
					newcityList.add(cityList.get((pageNum-1)*5+1));
					newcityList.add(cityList.get((pageNum-1)*5+2));
					newcityList.add(cityList.get((pageNum-1)*5+3));
					newcityList.add(cityList.get((pageNum-1)*5+4));
					newcityList.get(0);
				}else{
					for(int i=0;i<lastdatanum;i++){
						newcityList.add(cityList.get((pageNum-1)*5+i));
					}
				}
				Iterator its = newcityList.iterator();
		        while(its.hasNext()){
		            System.out.println(its.next()); }
				String objjsonlist = JSON.toJSONString(newcityList, true);
				System.out.println("objjsonlist:"+objjsonlist);
				System.out.println("{\"resultCode\":\"200\"" +",\"pageNum\":" + pageNum+ ",\"pageCount\":" + pageCount+ ",\"data\":" + objjsonlist +"}");
				return "{\"resultCode\":\"200\"" +",\"pageNum\":" + pageNum+ ",\"pageCount\":" + pageCount+ ",\"data\":" + objjsonlist +"}";

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
