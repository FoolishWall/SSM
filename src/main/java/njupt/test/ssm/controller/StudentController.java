package njupt.test.ssm.controller;


import njupt.test.ssm.common.ServerResponse;
import njupt.test.ssm.pojo.Student;
import njupt.test.ssm.service.StudentService;
import njupt.test.ssm.util.CheckRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @RequestMapping(value = "/showStudents")
    @ResponseBody
    public ServerResponse showAllStudent(){
        //登录校验交由AOP处理
        //校验成功
        return studentService.showAllStudent();
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(){
        return "TEST";
    }

    @RequestMapping(value = "/queryStudent")
    @ResponseBody
    public ServerResponse queryStudent(Student student){
        //登录校验交由AOP处理
        //校验成功
        return studentService.queryStudent(student);
    }
}




