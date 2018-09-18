package njupt.test.ssm.dao;

import njupt.test.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    /**
     * 登录校验
     * @return
     */
    User loginCheck(@Param("userId")Integer userId,@Param("userPassword")String userPassword);
}
