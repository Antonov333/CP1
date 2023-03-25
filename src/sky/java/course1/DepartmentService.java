package sky.java.course1;

public class DepartmentService {
    public static Department setDepartment(int deptNo, String deptName) {
        return new Department(deptNo, deptName);
    }
}
