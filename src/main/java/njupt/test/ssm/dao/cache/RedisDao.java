package njupt.test.ssm.dao.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import njupt.test.ssm.pojo.Student;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Repository
public class RedisDao {
    //定义redis数据库连接池属性
    private final JedisPool jedisPool;
    //定义序列化的约束属性
    private RuntimeSchema<Student> schema = RuntimeSchema.createFrom(Student.class);

    //定义redis数据库连接池配置信息
    private static final JedisPoolConfig config;
    //静态代码块
    static{
        config = new JedisPoolConfig();
        //设置最大空闲连接数
        config.setMaxIdle(10);
        //设置最大连接数
        config.setMaxTotal(30);
    }
    //构造函数，类加载时，填写连接属性，获取连接池对象
    public RedisDao(String ip, int port) {
        jedisPool = new JedisPool(config,ip, port);
    }

    public Student getStudentFromRedis(int studentID) {
        try {
            //从数据库连接池中获取一个数据库操作对象
            try (Jedis jedis = jedisPool.getResource()) {
                //设置key
                String key = "studentID:" + studentID;
                //没有实现内部序列化操作
                //get->byte[]->反序列化->Object()
                //采用自定义序列化Protostuff:需要一个空对象

                //获取key的字符数组
                byte[] bytes = jedis.get(key.getBytes());
                if (bytes != null) {

                    //空对象
                    Student student = schema.newMessage();
                    //填充空对象
                    ProtostuffIOUtil.mergeFrom(bytes, student, schema);
                    return student;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String putStudentToRedis(Student student) {
        //object->序列化->byte[]
        try {
            try (Jedis jedis = jedisPool.getResource()) {
                //设置key
                String key = "studentID:" + student.getStudentId();
                //将student对象序列化
                byte[] bytes = ProtostuffIOUtil.toByteArray(student, schema,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));

                //超时缓存，缓存的时间
                int timeout = 60 * 60;//1小时
                //将student对象写入redis
                return jedis.setex(key.getBytes(), timeout, bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
