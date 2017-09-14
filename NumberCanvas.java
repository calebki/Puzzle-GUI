import java.awt.*;
import javax.swing.*;

public class NumberCanvas extends Canvas {

    private int drawThis = -1;

    public NumberCanvas() {
	setPreferredSize(new Dimension(200,100));
    }

    public NumberCanvas(int d) {
	drawThis = d;
	setPreferredSize(new Dimension(200,200));
    }

    public void paint(Graphics g) {
	if(drawThis!=-1) {	    
	    g.setFont(new Font("Times New Roman", Font.PLAIN, 50));
	    g.setColor(Color.black);
	    g.drawString(Integer.toString(drawThis),75,75);
	}
    }

}