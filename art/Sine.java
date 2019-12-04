package art;

class Sine extends Graph {
    
    float T = 500;
    
    @Override
    float getY(float x) {
        return (float)(Math.sin(2*Math.PI/T*x) + Math.cos(4*Math.PI/T*x) + Math.sin(8*Math.PI/T*x));
    }
}
