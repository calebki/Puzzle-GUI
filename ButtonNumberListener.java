import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;


public class ButtonNumberListener implements ActionListener {

    private GameButton myButton;
    private Puzzle g;
    private GameFrame frame;

	JPopupMenu  menu;
	
    public ButtonNumberListener(GameButton clicker, Puzzle game1, GameFrame fr) {
		myButton = clicker;
		g = game1;
		frame = fr;
		
		// create a popup menu
		menu = new JPopupMenu("Menu");
		NumberChangeListener num = new NumberChangeListener(myButton,g,frame);
		
		JMenuItem one = new JMenuItem("One");
		menu.add(one);
		one.addActionListener(num);
		
		JMenuItem two = new JMenuItem("Two");
		menu.add(two);
		two.addActionListener(num);

		JMenuItem three = new JMenuItem("Three");
		menu.add(three);
		three.addActionListener(num);

		JMenuItem four = new JMenuItem("Four");
		menu.add(four);
		four.addActionListener(num);

		JMenuItem five = new JMenuItem("Five");
		menu.add(five);
		five.addActionListener(num);

		JMenuItem six = new JMenuItem("Six");
		menu.add(six);
		six.addActionListener(num);

		JMenuItem seven = new JMenuItem("Seven");
		menu.add(seven);
		seven.addActionListener(num);

		menu.add(new JMenuItem("Never Mind"));        
	}

	public void actionPerformed(ActionEvent e) {
		
		menu.show(myButton,myButton.getWidth()/2,myButton.getHeight()/2);
	}
}

