import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class KakurasuButton extends GameButton implements ActionListener {

	public KakurasuButton(Spot spot) {
	    super(spot);
	}
	
	/*  
	 * The method paintComponent(Graphics g) is called when
	 * java needs to draw the component
	 */
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);

	    if(s.getValue()==1) {
		g.setColor(Color.black);
		g.fillOval(50,10,100,100);
	    }

	    if(s.getValue()==2) {
		g.setColor(Color.red);
		g.setFont(new Font("Times New Roman", Font.PLAIN, 100));
		g.drawString("X",70,100);
	    }		
	}

	public void actionPerformed(ActionEvent e) {
	    if(s.getValue()==0) {
		s.setValue(1);
	    }
	    else if (s.getValue()==1) {
		s.setValue(2);
	    }
	    else {
		s.setValue(1);
	    }	
	    repaint();
	}
	
}