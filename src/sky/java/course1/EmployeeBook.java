package sky.java.course1;

public class EmployeeBook {
    private int numberOfPositions = 25;
    private Employee team[] = new Employee[numberOfPositions];

    public EmployeeBook() {
        System.out.println(team[numberOfPositions - 1]);
        System.out.println(team[numberOfPositions - 1] == null);
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
            System.out.println("New person hired as follows\n" + team[i]);
        } else {
            System.out.println("No vacant position at the moment");
        }
    }


    public void fire(int position) {
        System.out.println("Fire person out from company");
        team[position - 1] = null;
    }

    public void employeeChange(int position, int newDept, int newSalary) {
        int p = position - 1;
        if (team[p] == null) {
            System.out.println("No person hired to position No." + position);
        } else {
            team[p].setDeptId(newDept);
            team[p].setSalary(newSalary);
            System.out.println(team[p].getPerson() + " assigned to Dept.No" + team[p].getDeptId());
        }
    }


} // EmployBook class
