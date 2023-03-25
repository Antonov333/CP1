package sky.java.course1;

public class CP1base {
    public static int employeeCounter;
    public static Employee[] personnel = new Employee[10];
    public static Department[] depts = new Department[6];

    public static void main(String[] args) {
        System.out.println("\nCOURSE PROJECT 1\n" +
                             "----------------");

        Person john = new Person("John", "Peter", "Smith");
        Person anna = new Person("Anna", "Petrovna", "Ivanova");
        Person tatyana = new Person("Tatyana", "Fyodorovna", "Belova");
        Person ketsuro = new Person("Ketsuro", "Kaoru", "Fujiwara");

        Employee boss = new Employee(1, john, 1, 199999);
        Employee officeManager = new Employee(2, anna, 1, 60000);
        Employee salesManager = new Employee(3, tatyana, 2, 95000);
        Employee productionManager = new Employee(4, ketsuro, 3, 275000);

        enroll(boss);
        enroll(officeManager);
        enroll(salesManager);
        enroll(productionManager);

        String[] deptNames = new String[]{"Projected", "Management", "Sales", "Production", "Delivery", "Marketing"};

        for (int i = 0; i <= depts.length - 1; i++) {
            depts[i] = DepartmentService.setDepartment(i, deptNames[i]);
        }

        printMaxSalaryInfo();
        printMinimumSalaryInfo();
        printAverageSalary();
        printPersonnelInfo();
        printPersonnelNames();


    }

    public static void enroll(Employee candidate) {
        personnel[employeeCounter] = candidate;
        employeeCounter++;
    }

    public static int getMaxSalaryPersID() {
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

    public static int getMinSalaryPersID() {
        int n = 0,
                minSalary = personnel[0].getSalary();
        for (int i = 1; i <= employeeCounter - 1; i++) {
            if (minSalary > personnel[i].getSalary()) {
                n = i + 1;
                minSalary = personnel[i].getSalary();
            }
        }
        return n;
    }

    public static void printMinimumSalaryInfo() {
        int i = getMinSalaryPersID() - 1;
        System.out.println("\nMinimum salary of " + personnel[i].getSalary() +
                " earned " + personnel[i].getPerson() + " of " +
                depts[personnel[i].getDeptId()].getName() + " department");
    }


    public static void printMaxSalaryInfo() {
        int i = getMaxSalaryPersID() - 1;
        System.out.println("\nMaximum salary of " + personnel[i].getSalary() +
                " achieved " + personnel[i].getPerson() + " of " +
                depts[personnel[i].getDeptId()].getName() + " department");
    }

    public static void printPersonnelInfo() {
        System.out.println("\nCOMPANY CREW INFORMATION\n" +
                             "------------------------");
        for (int i=0 ; i<=employeeCounter-1 ; i++) {
            System.out.println(personnel[i].getPersId() + ". " + personnel[i].getPerson() +
                    "\t\t" + depts[personnel[i].getDeptId()] + "\tSalary: " + personnel[i].getSalary());
        }
    }

    public static void printPersonnelNames() {
        System.out.println("\nCOMPANY CREW LIST\n" +
                "-----------------");
        for (int i=0 ; i<=employeeCounter-1 ; i++) {
            System.out.println(personnel[i].getPersId() + ". " + personnel[i].getPerson());
        }

    }
    public static float calcAverageSalary(){
        int m =0 ;
        for (int i = 0 ; i < employeeCounter ; i++ ){
            m+=personnel[i].getSalary() ;
        }
        return (float) m / (float) employeeCounter;
    }

    public static void printAverageSalary() {
        System.out.println("\nAverage salary in company is " + calcAverageSalary());
    }

}
