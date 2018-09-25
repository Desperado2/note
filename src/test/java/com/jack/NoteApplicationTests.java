package com.jack;

import com.jack.common.Result;
import com.jack.entity.User;
import com.jack.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.jack.dao")
public class NoteApplicationTests {

	@Autowired
	private UserService userService;
	@Test
	public void contextLoads() {

	}

	@Test
	public void UserServiceTest(){
		User user = new User();
		user.setUsername("zhangsan");
		user.setPassword("123456");
		user.setSex(0);
		user.setEmail("1928524965@qq.com");
		Result result = userService.save(user);
		System.out.println(result);
	}

}
