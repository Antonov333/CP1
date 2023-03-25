package sky.java.course1;

public class CP1base {
    public static int employeeCounter;
    public static Employee[] personnel = new Employee[10];
    public static Department[] depts = new Department[6];

    public static void main(String[] args) {
        System.out.println("This is Course Project 1,  basic level");

        System.out.println("employeeCounter:" + employeeCounter);

        Person john = new Person("John", "Peter", "Smith");
        Person anna = new Person("Anna", "Petrovna", "Ivanova");
        Person tatyana = new Person("Tatyana", "Fyodorovna", "Belova");
        Person ketsuro = new Person("Ketsuro", "Kaoru", "Fujiwara");
        System.out.println(john + "\n" + anna + "\n" + tatyana + "\n" + ketsuro);

        Employee boss = new Employee(1, john, 1, 199999);
        Employee officeManager = new Employee(2, anna, 1, 60000);
        Employee salesManager = new Employee(3, tatyana, 2, 95000);
        Employee productionManager = new Employee(4, ketsuro, 3, 275000);

        enroll(boss);
        enroll(officeManager);
        enroll(salesManager);
        enroll(productionManager);

        for (int i = 0; i < employeeCounter; i++) {
            System.out.println(personnel[i]);
        }

        System.out.println("Max salary pers ID: " + maxSalaryPersID());


        String[] deptNames = new String[]{"Projected", "Management", "Sales", "Production", "Delivery", "Marketing"};

        for (int i = 0; i <= depts.length - 1; i++) {
            depts[i] = DepartmentService.setDepartment(i, deptNames[i]);
        }
    /**
        for (int i = depts.length - 1; i >= 0; i--) {
            System.out.println("i=" + i + " " + depts[i]);
        } */

        printMaxSalaryInfo();
        System.out.println(personnel[3].getSalary());
        System.out.println(personnel[maxSalaryPersID() - 1].getSalary() >= personnel[3].getSalary());

    }

    public static void enroll(Employee candidate) {
        personnel[employeeCounter] = candidate;
        employeeCounter++;
        System.out.println("Enrolled: " + personnel[employeeCounter - 1]);
    }

    public static int maxSalaryPersID() {
        int n = 0,
                maxSalary = 0;
        for (int i = 0; i <= employeeCounter - 1; i++) {
            if (maxSalary < personnel[i].getSalary()) {
                n = i + 1;
                maxSalary = personnel[i].getSalary();
            }
        }
        return n;
    }

    public static void printMaxSalaryInfo() {
        int i = maxSalaryPersID() - 1;
        System.out.println("\nMaximum salary of " + personnel[i].getSalary() +
                " achieved " + personnel[i].getPerson() + " of " +
                depts[personnel[i].getDeptId()].getName() + " department");
    }

}
