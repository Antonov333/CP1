package sky.java.course1;

import java.util.Arrays;

public class CP1top {

    DepartmentBook deptBook;

    public static Employee[] personnel = new Employee[10];
    public static Department[] depts = new Department[6];


    public static void main(String[] args) {
        System.out.println("\nCOURSE PROJECT 1 TOP\n" + "----------------" + "\nmost complicated level\n");

        String[] deptNames = new String[]{"Projected", "Management", "Sales", "Production", "Delivery", "Marketing"};

        for (int i = 0; i <= depts.length - 1; i++) {
            depts[i] = Department.setDepartment(i, deptNames[i]);
        }

        DepartmentBook deptBook = new DepartmentBook(depts);
        System.out.println(deptBook);
        deptBook.printDeptInfo(1);
        System.out.println(deptBook.getNumberOfDepts());

        EmployeeBook employeeBook = new EmployeeBook(15);

        Persons candidates = new Persons();

        System.out.println(employeeBook.getTeam().length);
        employeeBook.hire(candidates.john, 1, 19999);
        employeeBook.hire(candidates.anna, 1, 60000);
        employeeBook.hire(candidates.tatyana, 2, 95000);
        employeeBook.hire(candidates.ketsuro, 3, 275000);
        employeeBook.hire(candidates.gary, 5, 175000);
        employeeBook.hire(candidates.ryan, 4, 89000);
        employeeBook.hire(candidates.travis, 4, 79000);
        employeeBook.hire(candidates.brian, 2, 89000);
        employeeBook.hire(candidates.christine, 2, 79000);
        employeeBook.hire(candidates.dolby, 3, 249000);
        employeeBook.hire(candidates.wade, 4, 55000);

        System.out.println(Arrays.toString(employeeBook.getTeam()));

        System.out.println(deptBook);

        employeeBook.printAll();
        employeeBook.employeeChange(employeeBook.getPersonPosition(candidates.wade), 4, 59000);
        employeeBook.employeeChange(candidates.wade, 5, 59000);
        employeeBook.printPositionInfo(employeeBook.getPersonPosition(candidates.wade));
        employeeBook.employeeChange(new Person("X", "Y", "Z"), 3, 59000);
    }
}// CP1top class


