package ch.hslu.oop.sw07;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private final long ID;
    private String lastName;
    private String firstName;

    public Person(long id, String lastName, String firstName) {
        this.ID = id;
        setLastName(lastName);
        setFirstName(firstName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + ID +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Person person)) return false;
        return ID == person.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public int compareTo(Person person) {
        return String.CASE_INSENSITIVE_ORDER.compare(lastName + firstName, person.lastName + person.firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("last name cannot be null");
        }
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("first name cannot be null");
        }
        this.firstName = firstName;
    }

    public long getID() {
        return ID;
    }

}
