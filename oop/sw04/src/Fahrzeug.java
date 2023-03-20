public class Fahrzeug implements Switchable {

    private boolean isOn;
    private Switchable motor;
    private Switchable licht;

    @Override
    public void switchOn() {
        isOn = true;
    }

    @Override
    public void switchOff() {
        isOn = false;
    }

    @Override
    public boolean isSwitchedOn() {
        return isOn;
    }

    @Override
    public boolean isSwitchedOff() {
        return !isOn;
    }
}
