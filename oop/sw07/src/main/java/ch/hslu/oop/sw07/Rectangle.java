package ch.hslu.oop.sw07;

public final class Rectangle extends Shape {

    private final int width;
    private final int height;

    public Rectangle(final int x, final int y, final int width, final int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int getPerimeter() {
        return (2 * this.width) + (2 * this.height);
    }

    @Override
    public int getArea() {
        return this.width * this.height;
    }

}