import com.bino.tic_tac_toe.TicTacToeGame;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

class TicTacToeLauncher {
    
    public static void main(String[] args) {
        new LwjglApplication(new TicTacToeGame());
    }
}
