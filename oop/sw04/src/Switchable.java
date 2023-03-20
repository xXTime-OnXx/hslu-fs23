import java.util.List;

/**
 * functionalities of an object having 2 states ON and OFF
 */
public interface Switchable {

    /**
     * changes the state to ON
     */
    void switchOn();

    /**
     * changes the state to OFF
     */
    void switchOff();

    /**
     * @return true if the state is ON
     */
    boolean isSwitchedOn();

    /**
     * @return true if the state is OFF
     */
    boolean isSwitchedOff();

}