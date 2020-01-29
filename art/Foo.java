package art;

class Foo extends Curve {

    @Override
    boolean isPoint(double x, double y) {
        return x*x + y*y - 25 < 0; 
    }
}
