import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class NumberChangeListener implements ActionListener {
	
    private GameButton myButton;
    private Puzzle g;
    private GameFrame frame;

    public NumberChangeListener(GameButton jb, Puzzle game1, GameFrame fr) {
	myButton = jb;
	g = game1;
	frame = fr;
    }

    public void actionPerformed(ActionEvent e) {
	String action = e.getActionCommand();
	if (action.equals("One")) {
	    myButton.getSpot().setValue(1);
	}

	else if (action.equals("Two")) {
	    myButton.getSpot().setValue(2);	    
	}

	else if (action.equals("Three")) {
	    myButton.getSpot().setValue(3);
	}

	else if (action.equals("Four")) {
	    myButton.getSpot().setValue(4);
	}

	else if (action.equals("Five")) {
	    myButton.getSpot().setValue(5);
	}

	else if (action.equals("Six")) {
	    myButton.getSpot().setValue(6);
	}
	else if (action.equals("Seven")) {
	    myButton.getSpot().setValue(7);	
	}
	
    
	frame.repaint();

    }
		   
}