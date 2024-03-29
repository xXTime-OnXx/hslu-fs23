package ch.hslu.oop.sw05;

public class Circle extends Shape {

    private final int diameter;

    public Circle(final int x, final int y, final int diameter) {
        super(x, y);
        this.diameter = diameter;
    }

    public int getDiameter() {
        return diameter;
    }

    @Override
    public int getPerimeter() {
        return (int) (Math.PI * this.diameter);
    }

    @Override
    public int getArea() {
        return (int) (Math.PI * Math.pow(this.diameter / 2, 2));
    }


}
