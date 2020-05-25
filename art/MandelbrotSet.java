package art;

import java.awt.*;
import java.awt.event.KeyEvent;

class MandelbrotSet extends Plot {

    private int maxDivergence = 100;

    MandelbrotSet() {
        super(500, 500);
        //scale, camX, camY are variables inherited from Plot
        scale = 4.0 / 250;
        camX = 0;
        camY = 0;
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
    public void keyPressed(KeyEvent e) {
        char ch = e.getKeyChar();
        switch (ch) {
            case 'q':
                maxDivergence++;
                repaint();
                break;
            case 'e':
                maxDivergence--;
                repaint();
                break;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        long startTime = System.nanoTime();
        super.paintComponent(g);
        double timeTaken = (System.nanoTime() - startTime) * 1e-9f;
        System.out.print("\r" + timeTaken);
    }

    @Override
    Color getColor(double x, double y) {
        int foo = (int) ((double) getDivergence(x, y) / maxDivergence * 16777215);
        int r = foo % 256;
        foo /= 256;
        int g = foo % 256;
        foo /= 256;
        int b = foo % 256;
        return new Color(r, g, b, 255);
    }

    /**
     * @param cx the real part of the number
     * @param cy the imaginary part of the number
     * @return the number of iterations for the number's magnitude to become larger than 2
     */
    private int getDivergence(double cx, double cy) {
        double zx = cx, zy = cy;
        for (int i = 1; i <= maxDivergence; ++i) {
            //Checks if the square of the magnitude of the number is greater than 4 since sqrt is slower
            if (zx * zx + zy * zy > 4) {
                return maxDivergence - i + 1;
            } else {
                /*
                For a real number:-
                Zn = Zn-1^2 + c

                For a complex number:-
                Zn = (x + yi)^2 + cx + cyi
                   = x^2 - y^2 + 2xyi + cx + cyi
                   = (x^2 - y^2 + cx) + (2xy + cy)i
                 */
                double new_zx = zx * zx - zy * zy + cx;
                double new_zy = 2 * zx * zy + cy;
                zx = new_zx;
                zy = new_zy;
            }
        }
        return 0;
    }
}
