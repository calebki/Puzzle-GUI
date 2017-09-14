import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Solver implements ActionListener{

    private Puzzle g; 
    private GameFrame frame;
    private int GameNumber;
    private int count=0;
    
    public Solver(Puzzle game, GameFrame fr, int gn) {
	g = game;
	frame = fr; 
	GameNumber = gn;
    }

    public void actionPerformed(ActionEvent e) {
	if(label(0,0)) {
	    frame.setMessage("Here is a solution. Took " + count + " loops.");
	}
	else {
	    frame.setMessage("Unable to solve. Press reset then solve.");
	}
    }

    public boolean label(int row, int col) {
	if(row == g.getGrid().length) {
	    return g.checkConstraints();
	}

	if(g.getGrid()[row][col].checkLabeled()) {
	    int newcol = col + 1;
	    int newrow = row;
	    if(newcol == g.getGrid()[row].length) {
		newcol = 0;
		newrow = row + 1;
	    }
	    return label(newrow,newcol);
	}

	
	else {
	    for(int v: g.getPossibles()) {
		count = count + 1;
		g.setSpot(row,col,v);
		
		boolean check = g.checkConstraints();
		if(check) {
		    int newcol = col + 1;
		    int newrow = row;
		    if(newcol == g.getGrid()[row].length) {
			newcol = 0;
			newrow = row + 1;
		    }
		    if(label(newrow,newcol)) {
			return true;
		    }
		}		
	    }
	    g.unsetSpot(row,col);
	    return false;
	}	    
    }


}