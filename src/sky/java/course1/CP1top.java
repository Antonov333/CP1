package sky.java.course1;

public class CP1top {

    public static Department[] depts = new Department[6];

    public static void main(String[] args) {
        System.out.println("\nCOURSE PROJECT 1 TOP\n" + "----------------------" + "\nmost complicated level\n");

        String[] deptNames = new String[]{"Projected", "Management", "Sales", "Production", "Delivery", "Marketing"};

        for (int i = 0; i <= depts.length - 1; i++) {
            depts[i] = Department.setDepartment(i, deptNames[i]);
        }

        EmployeeBook employeeBook = new EmployeeBook(15);

        Persons candidates = new Persons();
        System.out.println(employeeBook.getTeam().length); // принимаем сотрудников в компанию
        employeeBook.hire(candidates.john, 1, 199999);
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

        employeeBook.printAll();
        employeeBook.employeeChange(employeeBook.getPersonPosition(candidates.wade), 4, 59000);
        employeeBook.employeeChange(candidates.wade, 5, 59000);
        employeeBook.printPositionInfo(employeeBook.getPersonPosition(candidates.wade));
        employeeBook.employeeChange(new Person("A", "B", "C"), 3, 59000);

        employeeBook.printDeptCrews();
        employeeBook.printDepts();
        employeeBook.printTotalSalary();
        employeeBook.printMinSalary();
        employeeBook.printMaxSalary();
        System.out.println("Number of persons hired: " + employeeBook.getPersonnelCount());
        employeeBook.printAverageSalary();

        int dept = 4;
        employeeBook.printDeptCrews();
        System.out.println(employeeBook.getDeptPersonnelCount(dept));
        employeeBook.printDeptStaff(dept);
        employeeBook.printDeptAverageSalary(dept);
        employeeBook.printDeptMinSalaryInfo(dept);
        employeeBook.printDeptMaxSalaryInfo(dept);
        System.out.println(employeeBook.getTeam()[employeeBook.getMaxSalaryPosition() - 1]);
        employeeBook.printAllnames();
        employeeBook.indexEmployeeSalary(candidates.anna, 10);
        employeeBook.indexAllSalaries(5);
        employeeBook.indexDeptSalaries(3, 10);

        System.out.println(employeeBook.getTeam()[employeeBook.getPersonPosition(candidates.anna) - 1]);

        employeeBook.fire(candidates.wade, 11);
        employeeBook.fire(candidates.wade);
    }
}// CP1top class


