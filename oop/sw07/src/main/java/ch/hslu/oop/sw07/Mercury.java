package ch.hslu.oop.sw07;

public class Mercury extends Element {

    public Mercury() {
        super("Hg", -38.829, 356.73);
    }

    @Override
    public String toString() {
        return "Mercury{" + super.toString() + ", warning=" + "TOXIC" + "}";
    }
}
