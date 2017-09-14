import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class KenKenButton extends GameButton implements ActionListener {

    private Color[] boxColor = {Color.blue, Color.yellow, Color.red, Color.green, Color.orange, Color.pink, Color.white, Color.gray};
    private KenKen game;

    public KenKenButton(KenKenspot spot, KenKen g) {
	super(spot);
	this.addActionListener(this);
	game = g;
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);

	 g.setFont(new Font("Times New Roman", Font.PLAIN, 50));
	 g.setColor(boxColor[((KenKenspot)s).getBox()-1]);
	 g.fillOval(0,0,150,150);
	 g.setColor(Color.black);
	 g.drawString(Integer.toString(game.getboxTarget()[((KenKenspot)s).getBox()-1]) + game.getboxOps()[((KenKenspot)s).getBox()-1],30,80);
	 if(s.getValue()!=0) 
	     g.drawString(Integer.toString(s.getValue()),230,120);
    }

    public void actionPerformed(ActionEvent e) {

    }
}