package cn.itheima.mybatis.junit;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itheima.mybatis.mapper.UserMapper;
import cn.itheima.mybatis.pojo.User;
import cn.itheima.mybatis.pojo.UserExample;

public class JunitTest {

	@Test
	public void testMapper() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		UserMapper userMapper = ac.getBean(UserMapper.class);

		UserExample example = new UserExample();
		String username = "明";
		example.createCriteria().andSexEqualTo("1").andUsernameLike("%" + username + "%");
		example.setOrderByClause("id desc");
		int countByExample = userMapper.countByExample(example);
		System.out.println("\n\n------");
		System.out.println(countByExample);
		System.out.println();

		User user = userMapper.selectByPrimaryKey(10);
		System.out.println("\n\n------");
		System.out.println(user);
		System.out.println();

		List<User> users = userMapper.selectByExample(example);
		System.out.println("\n\n------");
		for (User user2 : users) {
			System.out.println(user2);
		}
		System.out.println();

	}

}
