package sky.java.course1;

import static sky.java.course1.CP1top.depts;

public class EmployeeBook {
    private int numberOfPositions;
    private Employee team[] = new Employee[numberOfPositions];


    public EmployeeBook(int numberOfpositions) {
        this.numberOfPositions = numberOfpositions;
        this.team = new Employee[numberOfpositions];
    }

    public EmployeeBook(Employee[] team) {
        this.numberOfPositions = team.length;
        this.team = team;
    }

    public int getNumberOfPositions() {
        return numberOfPositions;
    }

    public void setNumberOfPositions(int numberOfPositions) {
        this.numberOfPositions = numberOfPositions;
    }

    public Employee[] getTeam() {
        return team;
    }

    public void setTeam(Employee[] team) {
        this.team = team;
    }

    public void hire(Person person, int deptID, int salary) {
        boolean hired = false;
        int i = 0;
        while (i < team.length && !hired) {
            if (team[i] == null) {
                team[i] = new Employee(i + 1, person, deptID, salary);
                hired = true;
                break;
            }
            i++;
        }
        if (hired) {
            System.out.println("New person hired as follows\n" + team[i] + depts[deptID]);
        } else {
            System.out.println("No vacant position at the moment");
        }
    }


    public void fire(int position) {
        System.out.print(team[position - 1]);
        team[position - 1] = null;
        System.out.println(" fired from company");
    }

    public void employeeChange(int position, int newDept, int newSalary) {
        int p = position - 1;
        if (team[p] == null) {
            System.out.println("No person hired to position No." + position);
        } else {
            team[p].setDeptId(newDept);
            team[p].setSalary(newSalary);
            System.out.println(team[p].getPerson() + " assigned to Dept.No. " + team[p].getDeptId() + " with salary of "
                    + team[p].getSalary());
        }
    }

    public void employeeChange(Person p, int newDept, int newSalary) {
        int n = getPersonPosition(p);
        if (n == -1) {
            System.out.println(p + " is not hired at the moment");
        } else {
            team[n - 1].setDeptId(newDept);
            team[n - 1].setSalary(newSalary);
            System.out.println(team[n - 1].getPerson() + " assigned to Dept.No " + team[n - 1].getDeptId() +
                    " with salary of " + team[n - 1].getSalary());
        }
    }


    public void printPositionInfo(int i) { // position in list, i.e. 1. John, 2. Anna, etc...
        System.out.println(team[i - 1]);
    }

    public int getDeptId(int p) {
        return team[p - 1].getDeptId();
    }

    public int getPersonPosition(Person person) {
        int p = -1;
        for (int i = 0; i < team.length; i++) {
            if (team[i] != null) {
                if (person.equals(team[i].getPerson())) {
                    p = i + 1;
                    break;
                }
            }
        }
        return p;
    }

    public void printAll() {
        System.out.println("\nCompany personnel");
        for (Employee e : team) {
            if (e != null) {
                System.out.println(e);
            }
        }
    }

    public void printAllnames() {
        System.out.println("\nCompany staff names");
        for (Employee e : team) {
            if (e != null) {
                System.out.println(e.getPerson());
            }
        }
    }

    public void printDeptCrews() {
        System.out.println("List of personnel by departments");
        int i = 0;
        for (; i < depts.length; i++) {

            System.out.println(depts[i].toString());
            for (int j = 0; j < team.length; j++) {
                if (team[j] != null) {
                    if (team[j].getDeptId() == i) {
                        System.out.println(team[j].getPerson());
                    }
                }
            }
            System.out.println("");
        }
    }

    public void printDepts() {
        for (Department d : depts) {
            System.out.println(d);
        }
    }

    public int getTotalSalary() {
        int total = 0;
        for (Employee employee : team) {
            if (employee != null) {
                total += employee.getSalary();
            }
        }
        return total;
    }

    public void printTotalSalary() {
        System.out.println("Total sum of salaries: " + getTotalSalary());
    }

    public int getMinSalary() {
        int s = 0;
        boolean firstIteration = true;
        for (Employee employee : team) {
            if (employee != null) {
                if (s > employee.getSalary() || firstIteration) {
                    s = employee.getSalary();
                    firstIteration = false;
                }
            }
        }
        return s;
    }

    public void printMinSalary() {
        int min = getMinSalary();
        System.out.println("Minimum salary of " + min + " earned by");
        for (Employee employee : team) {
            if (employee != null) {
                if (employee.getSalary() == min) {
                    System.out.println(employee);
                }
            }
        }

    }

    public int getMaxSalary() {
        int max = 0;
        for (Employee employee : team) {
            if (employee != null) {
                if (max < employee.getSalary()) {
                    max = employee.getSalary();
                }
            }
        }
        return max;
    }

    public void printMaxSalary() {
        int max = getMaxSalary();
        System.out.println("Maximum salary of " + max + " earned by");
        for (Employee employee : team) {
            if (employee != null) {
                if (employee.getSalary() == max) {
                    System.out.println(employee);
                }
            }
        }

    }

    public int getMaxSalaryPosition() {
        int max = getMaxSalary();
        int p = 0;
        int i = 0;
        for (; i < team.length; i++) {
            if (team[i] != null) {
                if (team[i].getSalary() == max) {
                    p = i + 1;
                    return p;
                }
            }
        }
        return p;
    }

    public int getPersonnelCount() {
        int c = 0;
        for (Employee e : team
        ) {
            if (e != null) {
                c++;
            }
        }
        return c;
    }

    public double getAverageSalary() {
        if (getPersonnelCount() != 0) {
            return (double) ((double) getTotalSalary() / (double) getPersonnelCount());
        } else {
            return -1.0d;
        }
    }

    public void printAverageSalary() {
        double a = getAverageSalary();
        if (a < 0) {
            System.out.println("No one hired yet");
        } else {
            System.out.printf("Average salary is %.2f\n", a);
        }

    }

    public int getDeptTotalSalary(int deptId) {
        int s = 0;
        for (Employee e : team
        ) {
            if (e == null) {
            } else {
                if (e.getDeptId() == deptId) {
                    s += e.getSalary();
                }
                ;
            }
        }
        return s;
    }

    public int getDeptPersonnelCount(int deptId) {
        int c = 0;
        for (Employee e : team
        ) {
            if (e == null) {
            } else {
                if (e.getDeptId() == deptId) {
                    c++;
                }
            }


        }
        return c;
    }

    public void printDeptStaff(int deptId) {
        System.out.println(depts[deptId]);
        for (Employee e : team
        ) {
            if (e == null) {
            } else {
                if (e.getDeptId() == deptId) {
                    System.out.println(e.getPerson());
                }
            }
        }
    }

    public void printDeptTotalSalary(int deptId) {
        System.out.println(depts[deptId] + "\n" + "Total salary over deparment " + getDeptTotalSalary(deptId));
    }

    public double getDeptAverageSalary(int deptId) {
        return (double) (getDeptTotalSalary(deptId)) / (double) (getDeptPersonnelCount(deptId));
    }

    public void printDeptAverageSalary(int deptId) {
        System.out.println("Average salary over " + depts[deptId] + " is " + getDeptAverageSalary(deptId));
    }

    public int getDeptMinSalaryPosition(int deptId) {
        int p = 0;
        int min = 0;
        int i = 0;
        boolean notUpdatedYet = true;
        for (; i < team.length; i++) {
            if (team[i] == null) {
            } else {
                if ((team[i].getDeptId() == deptId) && (notUpdatedYet || min > team[i].getSalary())) {
                    min = team[i].getSalary();
                    p = i + 1; // p=number of line in list (1,2,3,...), i=index in array (0,1,2,...);
                    notUpdatedYet = false;
                }
            }
        }
        return p;
    }

    public int getDeptMinSalary(int deptId) {
        int min = 0;
        int i = 0;
        boolean notUpdatedYet = true;
        for (; i < team.length; i++) {
            if (team[i] == null) {
            } else {
                if (team[i].getDeptId() == deptId && (min > team[i].getSalary() || notUpdatedYet)) {
                    min = team[i].getSalary();
                    notUpdatedYet = false;
                }
            }

        }
        return min;
    }

    public void printDeptMinSalaryInfo(int deptId) {
        System.out.println(depts[deptId]);
        int m = getDeptMinSalary(deptId);
        System.out.println("Minimum salary of " + m + " earned ");
        for (Employee e : team
        ) {
            if (e != null && e.getDeptId() == deptId && e.getSalary() == m) {
                System.out.println(e);
            }

        }
    }

    public int getDeptMaxSalaryPosition(int deptId) {
        int p = 0;
        int max = 0;
        int i = 0;
        for (; i < team.length; i++) {
            if (team[i] != null && team[i].getDeptId() == deptId && max < team[i].getSalary()) {
                max = team[i].getSalary();
                p = i + 1; // p=number of line in list (1,2,3,...), i=index in array (0,1,2,...)
            }
        }
        return p;
    }

    public int getDeptMaxSalary(int deptId) {
        int max = 0;
        int i = 0;
        for (; i < team.length; i++) {
            if (team[i] != null && team[i].getDeptId() == deptId && max < team[i].getSalary()) {
                max = team[i].getSalary();
            }
        }
        return max;
    }

    public void printDeptInfo(int deptId) {
        System.out.println(depts[deptId]);
        for (Employee e : team
        ) {
            if (e != null) {
                if (e.getDeptId() == deptId) {
                    System.out.println(e);
                }
            }
        }

    }

    public void printDeptMaxSalaryInfo(int deptId) {
        System.out.println(depts[deptId]);
        int m = getDeptMaxSalary(deptId);
        System.out.println("Maximum salary of " + m + " earned ");
        for (Employee e : team
        ) {
            if (e != null) {
                if (e.getDeptId() == deptId && e.getSalary() == m) {
                    System.out.println(e);
                }
            }
        }
    }

}// EmployeeBook class
