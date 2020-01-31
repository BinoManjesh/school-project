package art;

import java.awt.*;

class WeirdEqn extends Plot {

    public static void main(String[] args) {
        new WeirdEqn();
    }

    @Override
    Color getColor(double x, double y) {
        double s1 = x * x + y * y - 25;
        if (Math.abs(s1) < 1) {
            return Color.BLACK;
        } else {
            return null;
        }
    }
}
