import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SkyscraperButton extends GameButton implements ActionListener {
	
	public SkyscraperButton(Spot spot) {
	    super(spot);
	    this.addActionListener(this);
	    setPreferredSize(new Dimension(200,200));
	}
	
	/*  
	 * The method paintComponent(Graphics g) is called when
	 * java needs to draw the component
	 */
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);

	    g.setFont(new Font("Times New Roman", Font.PLAIN, 50));
	    g.setColor(Color.black);
	    if(s.getValue()!=0) 
		g.drawString(Integer.toString(s.getValue()),95,80);
	}

	public void actionPerformed(ActionEvent e) {

	}
	
}