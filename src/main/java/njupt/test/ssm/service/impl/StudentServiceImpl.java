package njupt.test.ssm.service.impl;

import njupt.test.ssm.common.ServerResponse;
import njupt.test.ssm.dao.StudentDao;
import njupt.test.ssm.exception.DelException;
import njupt.test.ssm.pojo.Student;
import njupt.test.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class StudentServiceImpl implements StudentService{
    //依赖注入
    @Autowired
    private StudentDao studentDao;

    /**
     * 这时可以指定具体的封装类的泛型类型
     * @return
     */
    @Override
    public ServerResponse<List<Student>> showAllStudent() {
        //DAO层查询数据
        List<Student> studentList = studentDao.showAllStudent();
        if (studentList.size()>0){
        return ServerResponse.createBySuccess("查询成功",studentDao.showAllStudent());
        }
        return ServerResponse.createByError("查询记录为空");
    }

    @Override
    public void banDelStudent(String test) throws DelException {

        if (test.equals("删除")){
            throw new DelException("禁止删除!");
        }
        else {
            System.out.println("删除成功!");
        }

        System.out.println("测试异常!");
    }

    @Override
    public ServerResponse<List<Student>> queryStudent(Student student) {
        List<Student> studentList = studentDao.selectStudent(student);
        if (studentList.size()>0){
            return ServerResponse.createBySuccess("查询成功",studentList);
        }
        return ServerResponse.createByError("查询记录为空");
    }
}
