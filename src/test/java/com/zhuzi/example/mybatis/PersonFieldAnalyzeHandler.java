package com.zhuzi.example.mybatis;

import com.google.gson.Gson;
import com.zhuzi.example.mybatis.bean.Person;
import com.zhuzi.mybatis.util.AbstractFieldAnalyzeHandler;

public class PersonFieldAnalyzeHandler implements AbstractFieldAnalyzeHandler<Person>{

	@Override
	public Person handler(Object obj) {
		if(obj == null || "".equals(obj)) {
			return null;
		}
		Gson gson = new Gson();
		return gson.fromJson(obj.toString(), Person.class);
	}

	@Override
	public String rehandler(Object obj) {
		if(obj == null) {
			return null;
		}
		return new Gson().toJson(obj);
	}

}
