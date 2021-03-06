package com.goforit.firstapple.user.mapper;

import com.goforit.firstapple.user.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by goforit on 16/7/24.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:core-service.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    @DirtiesContext
//    @Transactional
    public void testBase(){

        User user=new User();
        user.setUsername("fan");
        user.setPassword("123456");
        user.setPhone("123456");
        user.setEmail("111");
        user.setSex("man");
        user.create();

        userMapper.create(user);


    }
}
