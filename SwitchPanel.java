import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class SwitchPanel extends JPanel implements ActionListener {

    public SwitchPanel() {

	setPreferredSize(new Dimension(400,400));
    }

    public void actionPerformed(ActionEvent e) {
	repaint();
    }


}