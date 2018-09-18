package njupt.test.ssm.enums;

public enum StudentStatusEnum {
    SUCCESS(1,"添加成功"),
    FAILED(0,"操作失败")
    ;
    private int status;
    private String description;

    StudentStatusEnum(int status, String description) {
        this.status = status;
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}
