package njupt.test.ssm.service.impl;

import njupt.test.ssm.common.ServerResponse;
import njupt.test.ssm.dao.UserDao;
import njupt.test.ssm.pojo.User;
import njupt.test.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override

    public ServerResponse<User> loginCheck(String userId, String password) {
        User user = userDao.loginCheck(Integer.valueOf(userId),password);
        if (user!=null){
            return ServerResponse.createBySuccess("登录成功",user);
        }
        return ServerResponse.createByError("登录失败");
    }
}
