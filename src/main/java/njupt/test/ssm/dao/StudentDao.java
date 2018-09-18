package njupt.test.ssm.dao;

import njupt.test.ssm.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {

    List<Student> showAllStudent();

    Student queryStudentById(@Param("studentID") int studentId);

    /**
     * 联合查询,测试一：传参为类
     * @param student
     * @return
     */
    List<Student> selectStudent(Student student);

    /**
     * 联合查询，测试二：传参为字符串组合
     * @param studentId
     * @param studentName
     * @param studentClassid
     * @return
     */
    List<Student> selectStudentByParam(@Param("studentId")String studentId,
                                       @Param("studentName")String studentName,
                                       @Param("studentClassid")String studentClassid);
}
