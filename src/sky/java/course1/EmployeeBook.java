package sky.java.course1;

import java.util.Arrays;

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

    public void setNumberOfPositions(int numberOfPositions) {
        this.numberOfPositions = numberOfPositions;
    }

    public void setTeam(Employee[] team) {
        this.team = team;
    }


    public int getNumberOfPositions() {
        return numberOfPositions;
    }

    public Employee[] getTeam() {
        return team;
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
            System.out.println("New person hired as follows\n" + team[i] + CP1top.depts[deptID]);
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
            System.out.println(team[p].getPerson() + " assigned to Dept.No" + team[p].getDeptId() + "");
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
        for (Employee e : team) {
            System.out.println(e);
        }
    }

    public void printDeptCrews() {
        System.out.println("List of personnel by departments");
        int n = CP1top.depts.length;
    }


    /** @Override public String toString() {
    String s ="";
    for ( Employee e: team)
    {
    s=s+e.toString() ;
    }
    return s;
    }*/
} // EmployBook class
