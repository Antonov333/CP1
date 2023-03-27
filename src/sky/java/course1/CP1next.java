package sky.java.course1;

public class CP1next {

    public static int employeeCounter;
    public static Employee[] personnel = new Employee[10];
    public static Department[] depts = new Department[6];

    public static void main(String[] args) {
        System.out.println("\nCOURSE PROJECT 1 NEXT\n" + "----------------" + "\nadvanced level\n");

        Person john = new Person("John", "Peter", "Smith");
        Person anna = new Person("Anna", "Petrovna", "Ivanova");
        Person tatyana = new Person("Tatyana", "Fyodorovna", "Belova");
        Person ketsuro = new Person("Ketsuro", "Kaoru", "Fujiwara");

        Employee boss = new Employee(1, john, 1, 199999);
        Employee officeManager = new Employee(2, anna, 1, 60000);
        Employee salesManager = new Employee(3, tatyana, 2, 95000);
        Employee productionManager = new Employee(4, ketsuro, 3, 275000);

        enroll(boss, 1);
        enroll(officeManager, 1);
        enroll(salesManager, 2);
        enroll(productionManager, 3);

        String[] deptNames = new String[]{"Projected", "Management", "Sales", "Production", "Delivery", "Marketing"};

        for (int i = 0; i <= depts.length - 1; i++) {
            depts[i] = Department.setDepartment(i, deptNames[i]);
        }
        printPersonnelInfo();
        indexSalaryAllStaff(10); // вызов метода блока повышенной сложности
        printPersonnelInfo();

        /** Далее вызываются методы блока задач повышенной сложности
         При необходимости проверки правильности их работы могут вызываться также методы базового блока
         * */

        for (int i = 0; i < depts.length; i++) {
            printDeptInfo(i);
        }
        Person gary = new Person("Gary", "Alexandrovich", "Vainerchuk");
        Employee marketingManager = new Employee(1, gary, 5, 205000);
        enroll(marketingManager, 5);

        printPersonnelInfo();
        System.out.println(personnel[employeeCounter - 1]);

        printDeptInfo(5);

        printDeptMinSalaryInfo(1);
        printDeptMaxSalaryInfo(5);
        printDeptAvSalaryInfo(3);

        printDeptInfo(1);
        indexSalaryDeptStaff(1, 5);
        printDeptInfo(1);

        printDeptStaffNames(1);

        printSalaryHigher(200000);

        printSalaryLesser(150000);


    }

    public static void enroll(Employee candidate, int deptId) {
        personnel[employeeCounter] = candidate;
        personnel[employeeCounter].setDeptId(deptId);
        personnel[employeeCounter].setPersId(employeeCounter + 1);
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
        for (int i = 0; i <= employeeCounter - 1; i++) {
            System.out.println(personnel[i].getPersId() + ". " + personnel[i].getPerson() +
                    "\t\t" + depts[personnel[i].getDeptId()] + "\tSalary: " + personnel[i].getSalary());
        }
    }

    public static void printPersonnelNames() {
        System.out.println("\nCOMPANY CREW LIST\n" +
                "-----------------");
        for (int i = 0; i <= employeeCounter - 1; i++) {
            System.out.println(personnel[i].getPersId() + ". " + personnel[i].getPerson());
        }

    }

    public static float calcAverageSalary() {
        int m = 0;
        for (int i = 0; i < employeeCounter; i++) {
            m += personnel[i].getSalary();
        }
        return (float) m / (float) employeeCounter;
    }

    public static void printAverageSalary() {
        System.out.println("\nAverage salary in company is " + calcAverageSalary());
    }

    public static void indexSalaryAllStaff(int index) {
        int newSalary = 0;
        for (int i = 0; i <= employeeCounter - 1; i++) {
            newSalary = (personnel[i].getSalary()) * (index + 100) / 100;
            personnel[i].setSalary(newSalary);
        }
    }

    public static void printDeptInfo(int deptId) {

        System.out.println("\nDEPARTMENT NO." + deptId);
        System.out.println("Function: " + depts[deptId].getName().toUpperCase());
        for (int i = 0; i <= employeeCounter - 1; i++) {
            if (personnel[i].getDeptId() == deptId) {
                printEmployeeInfo(i);
            }
        }
    }

    public static void printEmployeeInfo(int persId) {
        System.out.println(personnel[persId].getPerson() + " Salary: " + personnel[persId].getSalary());
    }

    public static int countDeptPersonell(int deptId) {
        int deptPeopleCount = 0;

        for (int j = 0; j < employeeCounter; j++) {
            if (personnel[j].getDeptId() == deptId) {
                deptPeopleCount++;
            }
        }
        return deptPeopleCount;
    }

    public static void printDeptMinSalaryInfo(int deptId) {
        if (countDeptPersonell(deptId) == 0) {
            System.out.println("No personell hired to Dept. No." + deptId + " " + depts[deptId].getName());
        } else {
            int minSalary = -1,
                    minSalaryPersId = -1;
            for (int j = 0; j < employeeCounter; j++) {
                if (personnel[j].getDeptId() == deptId) {
                    if (minSalary < 0 || minSalary > personnel[j].getSalary()) {
                        minSalary = personnel[j].getSalary();
                        minSalaryPersId = j + 1;
                    }
                }
            }
            System.out.print("Dept. No." + deptId + ". " + depts[deptId].getName() +
                    ". Minimum salary of " + minSalary + " earned ");
            for (int j = 0; j < employeeCounter; j++) {
                if (personnel[j].getSalary() == minSalary) {
                    System.out.println(personnel[j].getPerson() + ".");
                }
            }

        }
    }

    public static void printDeptMaxSalaryInfo(int deptId) {
        if (countDeptPersonell(deptId) == 0) {
            System.out.println("No personell hired to Dept. No." + deptId + " " + depts[deptId].getName());
        } else {
            int maxSalary = -1,
                    maxSalaryPersId = -1;
            for (int j = 0; j < employeeCounter; j++) {
                if (personnel[j].getDeptId() == deptId) {
                    if (maxSalary < 0 || maxSalary < personnel[j].getSalary()) {
                        maxSalary = personnel[j].getSalary();
                        maxSalaryPersId = j + 1;
                    }
                }
            }
            System.out.print("Dept. No." + deptId + ". " + depts[deptId].getName() +
                    ". Maximum salary of " + maxSalary + " earned ");
            for (int j = 0; j < employeeCounter; j++) {
                if (personnel[j].getSalary() == maxSalary) {
                    System.out.println(personnel[j].getPerson() + ".");
                }
            }

        }
    }

    public static void printDeptAvSalaryInfo(int deptId) {
        int c = countDeptPersonell(deptId);
        int sum = 0;
        if (c == 0) {
            System.out.println("No personell hired to Dept. No." + deptId + " " + depts[deptId].getName());
        } else {

            for (int j = 0; j < employeeCounter; j++) {
                sum = +personnel[j].getSalary();
            }
        }

        System.out.print("Dept. No." + deptId + ". " + depts[deptId].getName() +
                ". Average salary is " + (double) (sum / c));

    }

    public static void indexSalaryDeptStaff(int deptId, int index) {
        int newSalary = 0;
        for (int i = 0; i <= employeeCounter - 1; i++) {
            if (personnel[i].getDeptId() == deptId) {
                newSalary = (personnel[i].getSalary()) * (index + 100) / 100;
                personnel[i].setSalary(newSalary);
            }
        }
    }

    public static void printDeptStaffNames(int deptId) {
        System.out.println(depts[deptId]);
        for (int i = 0; i <= employeeCounter - 1; i++) {
            if (personnel[i].getDeptId() == deptId) {
                System.out.println(personnel[i].getPerson());
            }
        }

    }

    public static int getMaxSalary() {
        return personnel[getMaxSalaryPersID() - 1].getSalary();
    }

    public static int getMinSalary() {
        return personnel[getMinSalaryPersID() - 1].getSalary();
    }


    public static void printSalaryHigher(int level) {
        if (level > getMaxSalary()) {
            System.out.println("Maximum salary in company of " + getMaxSalary() + " is lesser than " + level);
        }
        System.out.println("Salary over or equal " + level + " achieved");
        for (int i = 0; i <= employeeCounter - 1; i++) {
            if (personnel[i].getSalary() >= level) {
                System.out.println(personnel[i]);
            }
        }
    }

    public static void printSalaryLesser(int level) {
        if (level < getMinSalary()) {
            System.out.println("Minimum salary in company of " + getMinSalary() + " is higher than  " + level);
        }
        System.out.println("Salary lesser or equal " + level + " earned");
        for (int i = 0; i <= employeeCounter - 1; i++) {
            if (personnel[i].getSalary() <= level) {
                System.out.println(personnel[i]);
            }
        }
    }

} // CP1next class


