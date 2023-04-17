package ch.hslu.oop.sw07;

import java.util.Objects;

public class Person {

    private final long id;
    private String lastName;
    private String firstName;

    public Person(long id, String lastName, String firstName) {
        this.id = id;
        setLastName(lastName);
        setFirstName(firstName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Person person)) return false;
        return id == person.id && lastName.equals(person.lastName) && firstName.equals(person.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName);
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

    public long getId() {
        return id;
    }
}
