import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameButton extends JButton implements ActionListener {
    
    protected Spot s;

    public GameButton(Spot x) {
	s = x;
	this.addActionListener(this);
	setPreferredSize(new Dimension(200,200));
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);

	g.setFont(new Font("Times New Roman", Font.PLAIN, 50));
	g.setColor(Color.black);

    }

    public Spot getSpot() {
	return s;
    }

    public void actionPerformed(ActionEvent e) {
	
    }

}