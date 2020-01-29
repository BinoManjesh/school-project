package art;

interface Zoomable {
    
    double getCamX();
    
    double getCamY();
    
    void setCam(double camX, double camY);
    
    double getScale();
    
    void setScale(double scale);
    
    int getWidth();
    
    int getHeight();
    
    void repaint();
}
