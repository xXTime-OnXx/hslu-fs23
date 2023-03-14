public class Demo {
    public int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public int min(int a, int b) {
        if (a < b) {
            return a;
        }
        return b;
    }

    public int max(int a, int b, int c) {
        return max(max(a, b), c);
    }

    public int max1(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        }
        if (b > a && b > c) {
            return b;
        }
        return c;
    }

    public void forLoop() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }

    public void whileLoop() {
        int i = 1;
        while (i <= 10) {
            System.out.println(i++);
        }
    }

    public void doWhileLoop() {
        int i = 1;
        do {
            System.out.println(i++);
        } while (i <= 10);
    }

    public void floatWhileLoop() {
        float i = 0.9f;
        while (i <= 1.0f) {
            i += 0.000025f;
        }
    }

    public void floatForLoop() {
        float value = 0.9f;
        for (int i = 0; i < 4000; i++) {
            value += 0.000025f;
        }
        System.out.println("Value after 4000 Iterations: " + value);
    }

    public void printBox(final int width, final int height) {
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (h == 0 || h == height - 1 || w == 0 || w == width - 1) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}