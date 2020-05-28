package com.zhuzi.example.mybatis.test;

import com.zhuzi.example.mybatis.bean.TestBean;

public class TemplateTestField {

	public static void main(String[] args) {
		try {
			TestBean t = new TestBean();
			System.out.println(TestBean.class.getDeclaredFields());
			System.out.println(t.getClass().getDeclaredField("createTime"));
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	}
}
