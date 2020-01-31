package art;

import java.awt.*;

class MandelbrotSet extends Plot {

    private static final int size = 600;
    private static final int maxDivergence = 500;

    MandelbrotSet() {
        super(size, size);
        //scale, camX, camY are variables inherited from Plot
        scale = 4.0 / size;
        camX = -1.7490812690237831;
        camY = -4.9135633356879E-6;
    }

    /*
    Interesting points:- (set camX, camY to these values in the constructor to see)

    -1.9825307442357645 1.1269861165180146E-16
    -1.9854737218475564 -1.92962847813101E-5
    -1.9854736614426023 -1.9321688831440083E-5
    -0.8119294087512888 0.17181641810440956
    -1.7490812690237831 -4.9135633356879E-6
    -1.40881256903367 -0.1327512339998311
    -0.7264926148300772 -0.25148380542817095
     */

    public static void main(String[] args) {
        new MandelbrotSet();
    }

    @Override
    Color getColor(double x, double y) {
        int foo = (int) ((double)getDivergence(x, y) / maxDivergence * 16777215);
        int r = foo % 256;
        foo /= 256;
        int g = foo % 256;
        foo /= 256;
        int b = foo % 256;
        return new Color(r, g, b, 255);
    }

    private int getDivergence(double x, double y) {
        return getDivergence(x, y, x, y, maxDivergence);
    }

    /**
     * @param x the real part of the number
     * @param y the imaginary part of the number
     * @param cx the real part of the complex number c
     * @param cy the imaginary part of the complex number c
     * @param i the number of iterations left
     * @return the number of iterations for the number x + yi to become greater than 2 (by magnitude)
     */
    private int getDivergence(double x, double y, double cx, double cy, int i) {
        if (i <= 0) {
            return 0;
        }
        //Checks if the square of the magnitude of the number is greater than 4 since sqrt is slower
        else if (x * x + y * y > 4) {
            return i;
        } else {
            /*
            For a real number:-
            Zn = Zn-1^2 + c

            For a complex number:-
            Zn = (x + yi)^2 + cx + cyi
               = x^2 - y^2 + 2xyi + cx + cyi
               = (x^2 - y^2 + cx) + (2xy + cy)i
             */
            double new_x = x * x - y * y + cx;
            double new_y = 2 * x * y + cy;
            return getDivergence(new_x, new_y, cx, cy, i - 1);
        }
    }
}
