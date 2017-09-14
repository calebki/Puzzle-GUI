import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckListener implements ActionListener{

    private Puzzle g;
    private GameFrame frame;

    public CheckListener(Puzzle game, GameFrame fr) {
	g = game;
	frame = fr;
    }

    public void actionPerformed(ActionEvent e) {
	if(g.allSet() && g.checkConstraints()) {
	    frame.setMessage("Congratulation! You've solved the puzzle.");
	}
	else {
	    frame.setTempMessage("You are wrong!");
	}
	    
    }
}