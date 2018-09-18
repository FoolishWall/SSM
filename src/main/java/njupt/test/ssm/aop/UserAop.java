package njupt.test.ssm.aop;

import njupt.test.ssm.common.ServerResponse;
import njupt.test.ssm.pojo.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Component
@Aspect
public class UserAop {
    @Pointcut("execution(public * njupt.test.ssm.controller.StudentController.*(..))")
    public void pointCut(){}


    @Around("pointCut()")
    public ServerResponse checkRoleAop(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取请求域
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获取session中的信息
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            return ServerResponse.createByNeedLogin();
        }
        if (user.getUserRole()!=1){
            return ServerResponse.createByError("非管理员，无此权限!");
        }
        return (ServerResponse) joinPoint.proceed();
    }

}
