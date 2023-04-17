package ch.hslu.oop.sw07;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    public static final int PERSON_ID = 1;
    public static final String PERSON_LAST_NAME = "Muster";
    public static final String PERSON_FIRST_NAME = "Max";

    @Test
    void personConstructorShouldSetAllFields() {

        Person person = new Person(PERSON_ID, PERSON_LAST_NAME, PERSON_FIRST_NAME);

        assertEquals(PERSON_ID, person.getId());
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
    public void equalsContract() {
        EqualsVerifier.simple().forClass(Person.class)
                .withNonnullFields("lastName", "firstName")
                .verify();
    }

    @Test
    public void twoPersonWithEqualValuesShouldHaveSameHash() {
        Person person1 = new Person(PERSON_ID, PERSON_LAST_NAME, PERSON_FIRST_NAME);
        Person person2 = new Person(PERSON_ID, PERSON_LAST_NAME, PERSON_FIRST_NAME);

        assertEquals(person1, person2);
        assertEquals(person1.hashCode(), person2.hashCode());
    }

}