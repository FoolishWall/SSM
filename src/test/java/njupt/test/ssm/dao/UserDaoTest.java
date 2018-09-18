package njupt.test.ssm.dao;

import njupt.test.ssm.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {
    @Autowired
    UserDao userDao;
    @Test
    public void loginCheck() throws Exception {
        User user = userDao.loginCheck(1217043000,"123jay");
        System.out.println(user.toString());
    }

}