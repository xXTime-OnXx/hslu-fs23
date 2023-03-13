public class Demo {
    int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    int min(int a, int b) {
        if (a < b) {
            return a;
        }
        return b;
    }

    int max(int a, int b, int c) {
        return max(max(a, b), c);
    }

    int max1(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        }
        if (b > a && b > c) {
            return b;
        }
        return c;
    }


}