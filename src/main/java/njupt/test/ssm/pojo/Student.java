package njupt.test.ssm.pojo;

/**
 *
 */
public class Student {
    private int studentId;
    private String studentName;
    private String studentClassid;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClassid() {
        return studentClassid;
    }

    public void setStudentClassid(String studentClassid) {
        this.studentClassid = studentClassid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentClassid='" + studentClassid + '\'' +
                '}';
    }


}
