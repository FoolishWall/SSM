package njupt.test.ssm.util;

import njupt.test.ssm.common.ServerResponse;
import njupt.test.ssm.pojo.User;

import javax.servlet.http.HttpSession;

public class CheckRole {
    /**
     * 判断是否登录，是否为管理员
     * @param session
     * @return
     */
    public static ServerResponse checkIsLoginAndAdmin(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user == null){
            return ServerResponse.createByNeedLogin();
        }
        if (user.getUserRole()!=1){
            return ServerResponse.createByError("非管理员，无此权限!");
        }
        return ServerResponse.createByCheckSuccess();
    }
}
