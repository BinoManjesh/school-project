package art;

interface Zoomable {

    void setCam(double camX, double camY);

    double getCamX();

    double getCamY();

    double getScale();

    void setScale(double scale);

    int getWidth();

    int getHeight();

    void repaint();
}
