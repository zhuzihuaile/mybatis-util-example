package com.zhuzi.example.mybatis.test;

import java.util.List;

import com.zhuzi.mybatis.annotation.query.BeanField;

/**
 * 查询对象
 */
public class TestBeanQuery {
	@BeanField(fieldName="id")
	private List<Integer> idList;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getIdList() {
		return idList;
	}
	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}
	
}
