import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


class SwitchListener implements ActionListener {

    private GameFrame frame;
    private int GameNumber;

    public SwitchListener(GameFrame fr, int g) {
	frame = fr;
	GameNumber = g;
    }
    
    public void actionPerformed(ActionEvent e) {
	frame.getContentPane().removeAll();

	if(GameNumber == 1) {
	    frame.init1();
	}
	if(GameNumber == 2) {
	    frame.init2();
	}
	if(GameNumber == 3) {
	    frame.init3();
	}
	if(GameNumber == 4) {
	    frame.init4();
	}

	frame.validate();
	frame.repaint();
    }
}