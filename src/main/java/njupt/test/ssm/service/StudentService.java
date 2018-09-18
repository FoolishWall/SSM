package njupt.test.ssm.service;

import njupt.test.ssm.common.ServerResponse;
import njupt.test.ssm.exception.DelException;
import njupt.test.ssm.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    /**
     * 显示所有学生
     * @return
     */
    ServerResponse<List<Student>> showAllStudent();

    void banDelStudent(String test) throws DelException;

    /**
     * 联合查询，传参为类
     * @param student
     * @return
     */
    ServerResponse<List<Student>> queryStudent(Student student);
}
