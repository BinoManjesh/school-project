import com.bino.gravitation.GravitationGame;

class GravitySimulatorLauncher {

    /*
    Controls:
    space bar: to pause or resume the simulation (it is paused at first)
    scroll: to zoom in or out
    drag the mouse to move around the universe
    click anywhere to create a planet
    click on a planet to select it
    drag a planet with left click to move it
    drag a planet with right click to impart velocity (shown by the blue line)
    + / - : increase or decrease the size of the selected(red) planet
    backspace : delete the selected planet
    enter : delete all planets
     */

    public static void main(String[] args) {
        Launcher.launch(new GravitationGame());
    }
}
