import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class NewLook implements ActionListener {

        private GameFrame frame;

	public NewLook(GameFrame fr) {
	    frame = fr;
	}

	// removes all the components are reinitializes the Frame
	public void actionPerformed(ActionEvent e) {
	    frame.getContentPane().removeAll();
	    frame.init0();
	    frame.validate();
	    frame.repaint();
	}
}