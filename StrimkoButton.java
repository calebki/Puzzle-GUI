import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StrimkoButton extends GameButton implements ActionListener {

    private Color[] streamColor = {Color.blue, Color.yellow, Color.red, Color.green, Color.orange, Color.pink, Color.white}; 

	
	public StrimkoButton(Strimkospot spot) {
	    super(spot);
	    this.addActionListener(this);
	}
	
	/*  
	 * The method paintComponent(Graphics g) is called when
	 * java needs to draw the component
	 */
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);

	    g.setFont(new Font("Times New Roman", Font.PLAIN, 50));
	    g.setColor(streamColor[((Strimkospot)s).getStream()-1]);
	    g.fillOval(60,15,100,100);
	    g.setColor(Color.black);
	    if(s.getValue()!=0) 
		g.drawString(Integer.toString(s.getValue()),95,80);
	}

	public void actionPerformed(ActionEvent e) {

	}
	
}