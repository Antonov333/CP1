package sky.java.course1;

import java.util.Objects;

public class Employee {
    private int persId;
    private Person person;
    private int deptId;
    private int salary;

    public Employee() {
        persId = 0;
        person = new Person("", "", "");
        deptId = 0;
        salary = 0;
    }

    public Employee(int persId, Person person, int deptId, int salary) {
        if (persId <= 0) {
            throw new RuntimeException("Person corporate ID is incorrect");
        }
        if (person == null) {
            throw new RuntimeException("Person Data is incorrect");
        }
        if (deptId <= 0) {
            throw new RuntimeException("Department ID is incorrect");
        }
        if (salary < 0) {
            throw new RuntimeException("Salary data is incorrect");
        }
        this.persId = persId;
        this.person = person;
        this.deptId = deptId;
        this.salary = salary;

    }

    public int getPersId() {
        return persId;
    }

    public Person getPerson() {
        return person;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setPersId(int persId) {
        this.persId = persId;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return persId +
                ". " + person +
                ". Dept.No." + deptId +
                ". Salary=" + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return persId == employee.persId && deptId == employee.deptId && salary == employee.salary && person.equals(employee.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(persId, person, deptId, salary);
    }

    public void setEmployee(int persId, Person person, int deptId, int salary) {
        this.persId = persId;
        this.person = person;
        this.deptId = deptId;
        this.salary = salary;
    }

}
