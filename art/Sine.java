package art;

class Sine extends Graph {

    Sine() {
        super.xScale = 0.026f;
        super.yScale = 100;
    }

    public static void main(String[] args) {
        new Sine();
    }

    @Override
    double getY(double x) {
        return Math.sin(2 * x) + Math.cos(x);
    }
}
