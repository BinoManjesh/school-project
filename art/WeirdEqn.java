package art;

import java.awt.*;

class WeirdEqn extends Plot {

    private WeirdEqn() {
        scaleSpeed = 0.7;
    }

    public static void main(String[] args) {
        new WeirdEqn();
    }

    @Override
    Color getColor(double x, double y) {
        double s1 = Math.sin(x * y) - Math.cos(x * y);
        if (s1 < 0) {
            return Color.BLACK;
        } else {
            return null;
        }
    }
}
