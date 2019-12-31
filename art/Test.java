package art;

class Test extends Curve {
    
    Test() {
    }

    @Override
    boolean isPoint(double x, double y) {
        return (Math.abs(y*y*y + x*x*x - 1000000) <= 10000);
    }
}
