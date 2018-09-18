package njupt.test.ssm.service.impl;

import njupt.test.ssm.common.ServerResponse;
import njupt.test.ssm.pojo.User;
import njupt.test.ssm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void loginCheck() throws Exception {
        ServerResponse user= userService.loginCheck("1217043000","123jay");

    }

}