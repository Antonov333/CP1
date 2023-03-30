package sky.java.course1;

import java.util.Objects;

public class Person {
    private String firstName;
    private String fathersName;
    private String lastName;

    public String toString() {
        return firstName + " " + fathersName + " " + lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public String getLastName() {
        return lastName;
    }

    public Person(String firstName, String fathersName, String lastName) {
        this.firstName = firstName;
        this.fathersName = fathersName;
        this.lastName = lastName;
    }

    public void setPerson(String firstname, String fathersName, String lastname) {
        this.lastName = lastname;
        this.firstName = firstname;
        this.fathersName = fathersName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(fathersName, person.fathersName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, fathersName, lastName);
    }
}
