package njupt.test.ssm.service;

import njupt.test.ssm.common.ServerResponse;
import njupt.test.ssm.pojo.User;


public interface UserService {
    /**
     * 登录校验
     * @param userId
     * @param password
     * @return
     */
    ServerResponse<User> loginCheck(String userId, String password);
}
