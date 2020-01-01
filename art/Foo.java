package art;

class Foo extends Curve {
    
    Foo() {
        d = 0.5;
    }

    @Override
    boolean isPoint(double x, double y) {
        return (Math.abs(y*y*y*y*y + x*x*x*x*x - 1000000000) <= 100000000);
    }
}
