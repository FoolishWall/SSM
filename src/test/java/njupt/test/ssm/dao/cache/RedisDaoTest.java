package njupt.test.ssm.dao.cache;

import njupt.test.ssm.dao.StudentDao;
import njupt.test.ssm.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RedisDaoTest {

    @Autowired
    RedisDao redisDao;

    @Autowired
    StudentDao studentDao;

    @Test
    public void getStudentFromRedis() throws Exception {
        Student student = redisDao.getStudentFromRedis(1);
        if (student==null){
            student=studentDao.queryStudentById(1);
            System.out.println(redisDao.putStudentToRedis(student));
            System.out.println(redisDao.getStudentFromRedis(1));
        }else {
            System.out.println(student);
        }
    }

    @Test
    public void putStudentToRedis() throws Exception {
        Jedis jedis = new Jedis("127.0.0.1",6378);
        jedis.set("age","18");
        System.out.println(jedis.get("age"));
        jedis.close();
    }

}