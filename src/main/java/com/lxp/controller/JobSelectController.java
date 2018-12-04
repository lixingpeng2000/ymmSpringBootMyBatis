package com.lxp.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lxp.factory.ServiceFactory;

@RestController
@RequestMapping("/jobselect")
public class JobSelectController {
	@RequestMapping(method = RequestMethod.GET)
	public String getJobSelect(HttpServletRequest req) throws UnsupportedEncodingException{
		System.out.println("命中jobselect接口的get方法...");
		String city = req.getParameter("city");
		String jclass = req.getParameter("jclass");
		String dept = req.getParameter("dept");
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));		
		System.out.println("city:" + city);
		System.out.println("jclass:" + jclass);
		System.out.println("dept:" + dept);
		System.out.println("pageNum:" + pageNum);
		if ("请选择职能类型".equals(jclass) && "请选择部门".equals(dept)) {
			try {
				if (null != ServiceFactory.getIJobServiceIstance().findBycityList(city)) {
					List cityList = ServiceFactory.getIJobServiceIstance().findBycityList(city);
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
					return  "{\"resultCode\":\"500\"}";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (!"请选择职能类型".equals(jclass) && "请选择部门".equals(dept)) {
			try {
				if (null != ServiceFactory.getIJobServiceIstance().findByCityandJclassList(city, jclass)) {
					List cityList = ServiceFactory.getIJobServiceIstance().findByCityandJclassList(city, jclass);
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
		} else if ("请选择职能类型".equals(jclass) && !"请选择部门".equals(dept)) {
			try {
				if (null != ServiceFactory.getIJobServiceIstance().findByCityandDeptList(city, dept)) {
					List cityList = ServiceFactory.getIJobServiceIstance().findByCityandDeptList(city, dept);
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
					if (null != ServiceFactory.getIJobServiceIstance().findBySelectAllList(city, jclass, dept)) {
						System.out.println(city);
						System.out.println(jclass);
						System.out.println(dept);
						List cityList = ServiceFactory.getIJobServiceIstance().findBySelectAllList(city, jclass, dept);
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
						System.out.println(objjsonlist);
						System.out.println("{\"resultCode\":\"200\"" + ",\"data\":" + objjsonlist + ",\"pageNum\":"
								+ pageNum + ",\"pageCount\":" + pageCount + "}");
						return "{\"resultCode\":\"200\"" + ",\"data\":" + objjsonlist + ",\"pageNum\":"
								+ pageNum + ",\"pageCount\":" + pageCount + "}";
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				if (null != ServiceFactory.getIJobServiceIstance().findBySelectAllList(city, jclass, dept)) {
					List cityList = ServiceFactory.getIJobServiceIstance().findBySelectAllList(city, jclass, dept);
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
					String objjsonlist = "";
					if (pageCount == 0) {
						objjsonlist = "''";
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

					System.out.println(objjsonlist);
					System.out.println("{\"resultCode\":\"200\"" + ",\"data\":" + objjsonlist + ",\"pageNum\":"
							+ pageNum + ",\"pageCount\":" + pageCount + "}");
					return "{\"resultCode\":\"200\"" + ",\"data\":" + objjsonlist + ",\"pageNum\":"
							+ pageNum + ",\"pageCount\":" + pageCount + "}";

				} else {
					return "{\"resultCode\":\"500\"}";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
