package art;

class Foo extends Curve {
    
    Foo() {
    }

    @Override
    boolean isPoint(double x, double y) {
        return (Math.abs(y*y*y*y*y + x*x*x*x*x - 1000000000) <= 100000000);
    }
}
