package ch.hslu.oop.sw05;

/**
 * Extension of switchable, adds the ability to get the switched count
 */
public interface CountingSwitchable extends Switchable {

    long getSwitchCount();

}
