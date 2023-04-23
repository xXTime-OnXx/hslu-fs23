package ch.hslu.oop.sw07;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    public static final int PERSON_ID = 1;
    public static final String PERSON_LAST_NAME = "Muster";
    public static final String PERSON_FIRST_NAME = "Max";

    @Test
    void personConstructorShouldSetAllFields() {

        Person person = new Person(PERSON_ID, PERSON_LAST_NAME, PERSON_FIRST_NAME);

        assertEquals(PERSON_ID, person.getID());
        assertEquals(PERSON_LAST_NAME, person.getLastName());
        assertEquals(PERSON_FIRST_NAME, person.getFirstName());
    }

    @Test
    public void samePersonInstanceShouldBeEqual() {
        Person person = new Person(PERSON_ID, PERSON_LAST_NAME, PERSON_FIRST_NAME);

        assertEquals(person, person);
    }

    @Test
    public void newPersonInstanceShouldNotBeEqual() {
        Person person1 = new Person(PERSON_ID, PERSON_LAST_NAME, PERSON_FIRST_NAME);
        Person person2 = new Person(2, "Zimmer", "Hans");

        assertNotEquals(person1, person2);
    }

    @Test
    public void twoPersonWithEqualValuesShouldHaveSameHash() {
        Person person1 = new Person(PERSON_ID, PERSON_LAST_NAME, PERSON_FIRST_NAME);
        Person person2 = new Person(PERSON_ID, PERSON_LAST_NAME, PERSON_FIRST_NAME);

        assertEquals(person1, person2);
        assertEquals(person1.hashCode(), person2.hashCode());
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.simple().forClass(Person.class)
                .suppress(Warning.ALL_FIELDS_SHOULD_BE_USED)
                .verify();
    }

    @Test
    public void compareToShouldCompareByLastName() {
        Person person1 = new Person(1, "ABC", "EFG");
        Person person2 = new Person(2, "BCD", "EFG");

        assertTrue(person1.compareTo(person2) < 0);
    }

    @Test
    public void compareToShouldCompareByFirstName() {
        Person person1 = new Person(1, "ABC", "EFG");
        Person person2 = new Person(2, "ABC", "DEF");

        assertTrue(person1.compareTo(person2) > 0);
    }

    @Test
    public void compareToShouldReturnEqual() {
        Person person1 = new Person(1, "ABC", "ABC");
        Person person2 = new Person(2, "ABC", "ABC");

        assertEquals(0, person1.compareTo(person2));
    }

}