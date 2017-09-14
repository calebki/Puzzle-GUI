import java.awt.*;

public class GameRun {
   
    public static void main(String[] args) {

	GameFrame frame = new GameFrame();
	frame.init0();
	
	frame.setVisible(true);
	frame.setSize(new Dimension(3000,1600));
	frame.repaint();
    }
}