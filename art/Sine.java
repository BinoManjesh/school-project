package art;

class Sine extends Graph {
    
    Sine() {
        super.xScale = 0.1f;
    }
    
    @Override
    double getY(double x) {
        return Math.sin(x) + Math.cos(x);
    }
}
