public abstract class Puzzle {
    
    private int colSize;
    private int rowSize;
    protected Spot[][] grid;
    protected int[] possibles;

    public Puzzle() {
	
    }

    public Puzzle(int c, int r) {
	colSize = c;
	rowSize = r;
	grid = new Spot[rowSize][colSize];
    }

    public void setPossibles() {
	possibles = new int[getrowSize()];
	for(int i=0; i < possibles.length; i++) {
	    possibles[i] = i+1;
	}

    } 

    public void initialGrid() {
	for(int i=0; i < getrowSize(); i++) {
	    for(int j=0; j < getcolSize(); j++) {
		Spot temp = new Spot(0);
		grid[i][j] = temp;
	    }
	}
    }

    public int getcolSize() {
	return colSize;
    }

    public int getrowSize() {
	return rowSize;
    }

    public Spot[][] getGrid() {
	return grid;
    }

    public int[] getPossibles() {
	return possibles;
    }
        
    public Spot getSpot(int row, int col) {
	return grid[row][col];
    }

    public boolean latinSquare() {	
	Spot[] temp1 = new Spot[getrowSize()];
	Spot[] temp2 = new Spot[getcolSize()];

	for(int i=0; i < getrowSize(); i++) {
	    for(int j=0; j < getcolSize(); j++) {
		temp1[j] = getSpot(i,j);
		temp2[j] = getSpot(j,i);
	    }
	    if(!allDifferent(temp1) || !allDifferent(temp2)) {
		return false;
	    }
	}
	return true;
    }   

    public boolean allDifferent(Spot[] list) {
	for(int i = 0; i < list.length-1; i++) {
	    for(int j = i+1; j < list.length; j++) {
		if(list[i]!=null && list[j]!=null && list[i].getValue()!=0 && list[j].getValue()!=0) {
		    if(list[i].getValue()==list[j].getValue()) {
			return false;
		    }
		}
	    }
	}
	return true;
    }

    public void setSpot(int row, int col, int value) {
	grid[row][col].setValue(value);
    }

    public void unsetSpot(int row, int col) {
	setSpot(row,col,0);
    }
    
    public boolean allSet() {
	for(int i=0; i < getrowSize(); i++) {
	    for(int j=0; j < getcolSize(); j++) {
		if(getSpot(i,j).getValue()==0) {
		    return false;
		}
	    }
	}
	return true;
    }

    public abstract boolean checkConstraints();    
}