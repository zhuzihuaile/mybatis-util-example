package com.zhuzi.example.mybatis.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zhuzi.ApplicationTests;
import com.zhuzi.example.mybatis.bean.TestBean;
import com.zhuzi.mybatis.constant.MybatisXmlKeyConstant;
import com.zhuzi.mybatis.constant.SortAndLimitConstant;
import com.zhuzi.mybatis.constant.SortAndLimitConstant.Order;
import com.zhuzi.mybatis.core.query.Criteria;
import com.zhuzi.mybatis.core.query.Query;
import com.zhuzi.mybatis.template.MybatisTemplate;
import com.zhuzi.mybatis.util.ClassToMapUtil;

public class TemplateTest extends ApplicationTests{

	@Autowired
	private MybatisTemplate template;
	
	@Test
	@Transactional
	public void insertOne() {
		TestBean bean = new TestBean();
		bean.setName("name");
		bean.setTestName("testName");
		bean.setCreateTime(new Date());
		assertTrue(template.insert(bean));
		assertNotNull(bean.getId());
	}
	
	@Test
	@Transactional
	public void update() {
		TestBean bean = new TestBean();
		bean.setName("name");
		bean.setId(1);
		assertNotEquals(template.update(bean), 0);
	}
	
	@Test
	@Transactional
	public void delete() {
		TestBean bean = new TestBean();
		bean.setName("name");
		bean.setId(1);
		assertNotEquals(template.delete(bean), 0);
	}
	
	@Test
	public void selectOne() {
		TestBean bean = template.selectOne(TestBean.class);
		assertNotNull(bean);
		assertNotNull(bean.getId());
	}
	
	@Test
	public void selectIn() {
		Query query = new Query();
		List<Integer> list = Lists.newArrayList();
		list.add(0);
		list.add(1);
		query.addCriteria(Criteria.in("id", list));
		List<TestBean> beans = template.select(query.getWhereMap(), TestBean.class);
		assertNotNull(beans);
	}
	
	@Test
	public void selectEqual() {
		Query query = new Query();
		query.addCriteria(Criteria.equal("id", 1));
		query.addCriteria(Criteria.equal("name", "name"));
		List<TestBean> beans = template.select(query.getWhereMap(), TestBean.class);
		assertNotNull(beans);
	}
	
	@Test
	public void selectNotEqual() {
		Query query = new Query();
		query.addCriteria(Criteria.notEqual("id", 1));
		List<TestBean> beans = template.select(query.getWhereMap(), TestBean.class);
		assertNotNull(beans);
	}
	
	@Test
	public void selectRightLike() {
		Query query = new Query();
		query.addCriteria(Criteria.rightLike("test_name", "test"));
		List<TestBean> beans = template.select(query.getWhereMap(), TestBean.class);
		assertNotNull(beans);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void selectBetween() {
		Query query = new Query();
		query.addCriteria(Criteria.between("create_time", new Date(118, 01, 01), new Date(120, 01, 01)));
		Map<String, Object> map = query.getWhereMap();
		List<TestBean> beans = template.select(map, TestBean.class);
		System.out.println(beans);
		assertNotNull(beans);
	}
	
	@Test
	public void selectOneByOrder() {
		TestBean bean = template.selectOne(TestBean.class, SortAndLimitConstant.Sort("id", Order.DESC));
		assertNotNull(bean);
		assertNotNull(bean.getId());
	}
	
	@Test
	public void selectOneByOrder2() {
		TestBean bean = template.selectOne(TestBean.class, SortAndLimitConstant.Sort("id", null));
		assertNotNull(bean);
		assertNotNull(bean.getId());
	}
	
	@Test
	public void selectInteger() {
		Map<String, Object> map = Maps.newHashMap();
		map.put(MybatisXmlKeyConstant.TABLE_SELECT_FIELD.getName(), "id");
		map.putAll(ClassToMapUtil.getTableMap(TestBean.class));
		List<Integer> list = template.select(map, Integer.class);
		assertNotNull(list);
	}
	
	@Test
	public void selectString() {
		Map<String, Object> map = Maps.newHashMap();
		map.put(MybatisXmlKeyConstant.TABLE_SELECT_FIELD.getName(), "name");
		map.putAll(ClassToMapUtil.getTableMap(TestBean.class));
		List<String> list = template.select(map, String.class);
		System.out.println(list);
		assertNotNull(list);
	}
	
	@Test
	public void selectOneString() {
		Map<String, Object> map = Maps.newHashMap();
		map.put(MybatisXmlKeyConstant.TABLE_SELECT_FIELD.getName(), "name");
		map.putAll(ClassToMapUtil.getTableMap(TestBean.class));
		String str = template.selectOne(map, String.class);
		System.out.println(str);
		assertNotNull(str);
	}
}
