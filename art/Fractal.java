package art;

class Fractal extends Curve {
    
    boolean isPoint(double x, double y) {
        return x*y - Math.tan(x*y) < 0;
    }
}
