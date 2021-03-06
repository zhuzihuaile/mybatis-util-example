示例说明
==
* 本工程是一个标准的spring boot工程，配置信息在src/main/resources/application.yml文件中
* 运行示例在src/test/java文件夹的TemplateTest

运行说明
==
* 将本工程和[mybatis-util](https://github.com/zhuzihuaile/mybatis-util)项目直接导入到IDE中,
* 运行前需要修改src/main/resources/application.yml文件,将其中涉及到 MySQL 配置相关的部分改成自己的配置
* 执行/src/test/resources/example.sql
* 示例导入到IDE中后可以打开com.zhuzi.example.mybatis.test.TemplateTest类,这是一个测试类,可以直接执行测试类

对象实例
==
```java
/** 实体对象 */
@TableName(name="test")
public class TestBean {
	@GeneratedValue
	private Integer id;
	private String name;
	private String testName;
	private Date createTime;
	
	@FieldAnalyzeHandler(handler = PersonFieldAnalyzeHandler.class)
	private Person person;
	
```

```java
/** 数据转换实例 */
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
```

```java
/** 查询对象 */
public class TestBeanQuery {
	@BeanField(fieldName="id")
	private List<Integer> idList;
	private String name;
```


