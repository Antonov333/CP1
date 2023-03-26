package sky.java.course1;

public class Department {
    private int deptNo = 0;
    private String name = " ";

    public void setName(String name) {
        this.name = name;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public Department(int deptNo, String name) {
        this.deptNo = deptNo;
        this.name = name;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dept No." + deptNo + ": " + name;
    }

    public static Department setDepartment(int deptNo, String deptName) {
        return new Department(deptNo, deptName);
    }
}
