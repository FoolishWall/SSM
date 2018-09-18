package njupt.test.ssm.controller;

import njupt.test.ssm.common.ServerResponse;
import njupt.test.ssm.pojo.User;
import njupt.test.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController  {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/loginCheck",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<User> loginCheck(HttpSession session, @RequestParam("userId") String userId,
    @RequestParam("userPassword")String userPassword){
        ServerResponse<User> serverResponse = userService.loginCheck(userId,userPassword);
        if (serverResponse.checkIsSuccess()){
            //设置session
            session.setAttribute("user",serverResponse.getData());
            return serverResponse;
        }
        return ServerResponse.createByError("账号或密码错误！");
    }
}
