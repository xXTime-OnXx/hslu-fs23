public class Motor implements Switchable {

    private int rpm;

    @Override
    public void switchOn() {
        rpm = 1;
    }

    @Override
    public void switchOff() {
        rpm = 0;
    }

    @Override
    public boolean isSwitchedOn() {
        return rpm != 0;
    }

    @Override
    public boolean isSwitchedOff() {
        return rpm == 0;
    }
}
