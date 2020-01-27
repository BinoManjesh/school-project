package art;

interface Zoomable {
    
    public void setCam(double camX, double camY);
    
    public double getCamX();
    
    public double getCamY();
    
    public double getScale();
    
    public void setScale(double scale);
    
    public int getWidth();
    
    public int getHeight();
    
    public void repaint();
}
