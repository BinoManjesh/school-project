import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.bino.gravitation.GravitationGame;

class GravitationLauncher {

    public static void main(String[] args) {
        LwjglApplication a = new LwjglApplication(new GravitationGame());
    }
}
