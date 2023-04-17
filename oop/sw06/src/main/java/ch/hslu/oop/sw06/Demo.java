package ch.hslu.oop.sw06;

public class Demo {
    public int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public int max(int a, int b, int c) {
        return max(max(a, b), c);
    }
}