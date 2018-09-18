package njupt.test.ssm.dao;

import njupt.test.ssm.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class StudentDaoTest {

    @Resource
    private StudentDao studentDao;

    @Test
    public void showAllStudent() throws Exception {
        for (Student student:studentDao.showAllStudent()) {
            System.out.println(student.toString());
        }
    }

    @Test
    public void showOneStudent(){
        System.out.println(studentDao.queryStudentById(1));
    }

    @Test
    public void queryStudent(){
        Student student = new Student();
        student.setStudentName("大");
        student.setStudentClassid("1");
        System.out.println(studentDao.selectStudent(student));
    }

    @Test
    public void queryStudent2(){
        System.out.println(studentDao.selectStudentByParam("",
                "咪总","1"));
    }
}