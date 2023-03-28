package sky.java.course1;

import java.util.Arrays;

public class DepartmentBook { // for most complicated

    private int numberOfDepts;

    private Department[] listOfDepts = new Department[numberOfDepts];

    public DepartmentBook(Department[] listOfDepts) {
        this.numberOfDepts = listOfDepts.length;
        this.listOfDepts = listOfDepts;
    }

    public int getNumberOfDepts() {
        return numberOfDepts;
    }

    public Department[] getListOfDepts() {
        return listOfDepts;
    }

    @Override
    public String toString() {
        return "DepartmentBook{" +
                "numberOfDepts=" + numberOfDepts +
                "\n listOfDepts=" + Arrays.toString(listOfDepts) +
                '}';
    }

    public void printDeptInfo(int deptId) {
        System.out.println(listOfDepts[deptId]);
    }
}
