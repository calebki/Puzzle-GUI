import java.awt.*;
import javax.swing.*;
import java.util.Scanner;
import java.io.File;

public class GameFrame extends JFrame {

    private JLabel message;
    private int buttonCount;
    private GameButton[] buttons;

    public void init1() {
	
	// Exit when window in closed
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	Container ct = getContentPane();

	int[] streamPosition = {1,1,1,3,4,4,4,1,2,3,1,7,4,7,2,1,3,1,7,4,7,
	                        3,2,2,3,7,4,7,2,3,3,5,6,7,4,5,2,2,5,5,6,6,
	                        5,5,5,6,6,6,6};
	Strimko game = new Strimko(7,7,streamPosition);

	ct.setLayout(new GridLayout(game.getGrid().length+1, game.getGrid()[1].length));

	buttonCount = 49;
	buttons = new StrimkoButton[buttonCount];

	for (int i=0; i<game.getGrid().length; i++) {
	    for(int j=0; j<game.getGrid()[1].length; j++) {
 
		GameButton jb = new StrimkoButton((Strimkospot)game.getSpot(i,j));
		buttons[i+game.getGrid().length*j] = jb;
		ButtonNumberListener nc = new ButtonNumberListener(jb, game, this);
		ct.add(jb);
		jb.addActionListener(nc);

	    }
	}

	message = new JLabel("You are playing Strimko");
	ct.add(message);

	JPanel controlRow = new JPanel();
	ct.add(controlRow);	

	JButton checkPuzzle = new JButton("Check");
	controlRow.add(checkPuzzle);
	checkPuzzle.addActionListener(new CheckListener(game, this));

	JButton solvePuzzle = new JButton("Give up?");
	controlRow.add(solvePuzzle);

	Solver solve = new Solver(game, this, 1);
	solvePuzzle.addActionListener(solve);

	JButton s = new JButton("Switch");
	controlRow.add(s);
	s.addActionListener(new NewLook(this));

	JButton rb = new JButton("Reset");
	controlRow.add(rb);
	rb.addActionListener(new SwitchListener(this,1));

    }

    public void init2() {

	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container ct = getContentPane();

	int[] r = new int[5];
	int[] c = new int[5];

	File file = new File("KS.dat");
 
	try {
	    Scanner sc = new Scanner(file);
	    int z = 0;
	    while(sc.hasNextLine()) {
		r[z] = sc.nextInt();
		c[z] = sc.nextInt();
		z++;
	    }
	}

	catch(Exception ex) {
	    ex.printStackTrace();
	}

	Kakurasu game = new Kakurasu(5,r,c);	

	buttonCount = 25;
	buttons = new KakurasuButton[buttonCount];

	ct.setLayout(new GridLayout(8,7));

	JPanel topRow = new JPanel();
	ct.add(topRow);
	NumberCanvas topLeftCorner = new NumberCanvas();
	NumberCanvas topRightCorner = new NumberCanvas();
	NumberCanvas bottomLeftCorner = new NumberCanvas();
	NumberCanvas bottomRightCorner = new NumberCanvas();

	topRow.add(topLeftCorner);
	for(int i=0; i<game.getGrid()[1].length; i++) {
	    NumberCanvas temp = new NumberCanvas(i+1);
	    topRow.add(temp);
	}
	topRow.add(topRightCorner);

	for(int i=0; i<game.getGrid().length; i++) {
	    JPanel newRow = new JPanel();
	    ct.add(newRow);
	    NumberCanvas temp = new NumberCanvas(i+1);
	    newRow.add(temp);
	    for(int j=0; j<game.getGrid()[1].length; j++) {
		GameButton jb = new KakurasuButton(game.getSpot(i,j));
		newRow.add(jb);
		buttons[i+game.getGrid().length*j] = jb;
	    }
	    temp = new NumberCanvas(game.getrowTarget()[i]);
	    newRow.add(temp);
	}

	JPanel bottomRow = new JPanel();
	ct.add(bottomRow);
	bottomRow.add(bottomLeftCorner);
	for(int i=0; i<game.getGrid()[1].length; i++) {
	    NumberCanvas temp = new NumberCanvas(game.getcolTarget()[i]);
	  bottomRow.add(temp);
	}
	bottomRow.add(bottomRightCorner);

	JPanel controlRow = new JPanel();
	ct.add(controlRow);

	message = new JLabel("You are playing Kakurasu");
	controlRow.add(message);

	JButton checkPuzzle = new JButton("Check");
	controlRow.add(checkPuzzle);
	checkPuzzle.addActionListener(new CheckListener(game, this));

	JButton solvePuzzle = new JButton("Give up?");
	controlRow.add(solvePuzzle);

	Solver solve = new Solver(game, this, 2);
	solvePuzzle.addActionListener(solve);

	JButton s = new JButton("Switch");
	controlRow.add(s);
	s.addActionListener(new NewLook(this));

	JButton rb = new JButton("Reset");
	controlRow.add(rb);
	rb.addActionListener(new SwitchListener(this,2));
    }

    public void init3() {
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container ct = getContentPane();
	ct.setLayout(new GridLayout(10,9));

	//int[] top = {3,1,3,2,3,2,2};
	//int[] bottom = {3,3,1,2,2,3,5};
	//int[] right = {3,1,2,2,3,3,4};
	//int[] left = {2,3,1,3,2,3,3};
	int[] top = new int[7];
	int[] bottom = new int[7];
	int[] right = new int[7];
	int[] left = new int[7];
	int[] setup = new int[27];

	File file = new File("SS.dat");
	String stop;
	try {
	    Scanner sc = new Scanner(file);
	    int z = 0;
	    while(sc.hasNextInt()) {
		top[z] = sc.nextInt();
		z++;
	    }
	    stop = sc.next();
	    z=0;
	    while(sc.hasNextInt()) {
		bottom[z] = sc.nextInt();
		z++;
	    }
	    stop = sc.next();
	    
	    z=0;
	    while(sc.hasNextInt()) {
		right[z] = sc.nextInt();
		z++;
	    }
	    stop = sc.next();
	    
	    z=0;
	    while(sc.hasNextInt()) {
		left[z] = sc.nextInt();
		z++;
	    }
	    stop = sc.next();
	    
	    z=0;
	    while(sc.hasNextInt()) {
		setup[z] = sc.nextInt();
		z++;
	    }
	}

	catch(Exception ex) {
	    ex.printStackTrace();
	}

	Skyscraper game = new Skyscraper(7,right,left,top,bottom,setup);

	buttonCount = 49;
	buttons = new SkyscraperButton[buttonCount];

	JPanel topRow = new JPanel();
	ct.add(topRow);
	NumberCanvas topLeftCorner = new NumberCanvas();
	NumberCanvas topRightCorner = new NumberCanvas();
	NumberCanvas bottomLeftCorner = new NumberCanvas();
	NumberCanvas bottomRightCorner = new NumberCanvas();

	topRow.add(topLeftCorner);
	for(int i=0; i<game.getGrid()[1].length; i++) {
	    NumberCanvas temp = new NumberCanvas(game.getviewFromTop()[i]);
	    topRow.add(temp);
	}
	topRow.add(topRightCorner);

	for(int i=0; i<game.getGrid().length; i++) {
	    JPanel newRow = new JPanel();
	    ct.add(newRow);
	    NumberCanvas temp = new NumberCanvas(game.getviewFromLeft()[i]);
	    newRow.add(temp);
	    for(int j=0; j<game.getGrid()[1].length; j++) {
		GameButton jb = new SkyscraperButton(game.getSpot(i,j));
		newRow.add(jb);
		buttons[i+game.getGrid().length*j] = (GameButton)jb;
		ButtonNumberListener nc = new ButtonNumberListener(jb, game, this);
		jb.addActionListener(nc);
	    }
	    temp = new NumberCanvas(game.getviewFromRight()[i]);
	    newRow.add(temp);
	}

	JPanel bottomRow = new JPanel();
	ct.add(bottomRow);
	bottomRow.add(bottomLeftCorner);
	for(int i=0; i<game.getGrid()[1].length; i++) {
	    NumberCanvas temp = new NumberCanvas(game.getviewFromBottom()[i]);
	    bottomRow.add(temp);
	}
	bottomRow.add(bottomRightCorner);

	JPanel controlRow = new JPanel();
	ct.add(controlRow);

	message = new JLabel("You are playing Skyscraper");
	controlRow.add(message);

	JButton checkPuzzle = new JButton("Check");
	controlRow.add(checkPuzzle);
	checkPuzzle.addActionListener(new CheckListener(game, this));

	JButton solvePuzzle = new JButton("Give up?");
	controlRow.add(solvePuzzle);

	Solver solve = new Solver(game, this, 3);
	solvePuzzle.addActionListener(solve);

	JButton s = new JButton("Switch");
	controlRow.add(s);
	s.addActionListener(new NewLook(this));	

	JButton rb = new JButton("Reset");
	controlRow.add(rb);
	rb.addActionListener(new SwitchListener(this,3));
    }

    public void init4() {

	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container ct = getContentPane();

	int[] boxPosition = {1,1,2,3,4,5,2,3,4,5,6,7,8,8,6,7};
	int[] t = {1,7,2,4,12,2,4,2};
	String[] bo = {"-", "+", "-", "+", "*", "/", "+", "-"};
	KenKen game = new KenKen(4,boxPosition,t, bo);

	ct.setLayout(new GridLayout(game.getGrid().length+1, game.getGrid()[1].length));

	buttonCount = 16;
	buttons = new KenKenButton[buttonCount];

	for (int i=0; i<game.getGrid().length; i++) {
	    for(int j=0; j<game.getGrid()[1].length; j++) {
 
		GameButton jb = new KenKenButton((KenKenspot)game.getSpot(i,j), game);
		buttons[i+game.getGrid().length*j] = jb;
		ButtonNumberListener2 nc = new ButtonNumberListener2(jb, game, this);
		ct.add(jb);
		jb.addActionListener(nc);

	    }
	}

	message = new JLabel("You are playing KenKen");
	ct.add(message);

	JPanel controlRow = new JPanel();
	ct.add(controlRow);	

	JButton checkPuzzle = new JButton("Check");
	controlRow.add(checkPuzzle);
	checkPuzzle.addActionListener(new CheckListener(game, this));

	JButton solvePuzzle = new JButton("Give up?");
	controlRow.add(solvePuzzle);

	Solver solve = new Solver(game, this, 4);
	solvePuzzle.addActionListener(solve);

	JButton s = new JButton("Switch");
	controlRow.add(s);
	s.addActionListener(new NewLook(this));

	JButton rb = new JButton("Reset");
	controlRow.add(rb);
	rb.addActionListener(new SwitchListener(this,4));
    }





    public void init0() {
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container contentPane = this.getContentPane();

	contentPane.setLayout(new GridLayout(1,4));

	JButton change1 = new JButton("Strimko");
	contentPane.add(change1);
	change1.addActionListener(new SwitchListener(this,1));

	JButton change2 = new JButton("Kakurasu");
	contentPane.add(change2);
	change2.addActionListener(new SwitchListener(this,2));

	JButton change3 = new JButton("SkyScraper");
	contentPane.add(change3);
	change3.addActionListener(new SwitchListener(this,3));

	JButton change4 = new JButton("KenKen");
	contentPane.add(change4);
	change4.addActionListener(new SwitchListener(this,4));

	
    }

    public void setMessage(String message1) {
	message.setText(message1);

	for (GameButton b : buttons) {
	    b.setEnabled(false);
	}
    }

    public void setTempMessage(String message2) {
	message.setText(message2);
    }
}
