public class Strimko extends Puzzle {

    private int[] streamSetup;

    public Strimko(int c, int r, int[] streamLayout) {
	super(c,r);
	setPossibles();
	streamSetup = streamLayout;
	initialGrid();
    }

    public void initialGrid() {
	for(int i=0; i < getrowSize(); i++) {
	    for(int j=0; j < getcolSize(); j++) {
		Strimkospot temp = new Strimkospot(0,streamSetup[i*getrowSize()+j]);
		grid[i][j] = temp;
	    }
	}

	setSpot(0,6,2);
	setSpot(1,0,4);
	setSpot(1,1,6);
	setSpot(1,2,5);
	setSpot(2,0,5);
	setSpot(2,2,7);
	setSpot(2,5,4);
	setSpot(4,4,4);
	setSpot(4,6,5);
	setSpot(5,4,6);
	setSpot(5,5,2);
	setSpot(5,6,3);
    }
    
    public boolean checkConstraints() {
	if(latinSquare())
	    return streamDifferent();
	
	return false;
    }

    public boolean streamDifferent() {
	Spot[] temp = new Spot[getrowSize()];

	for(int i=1; i < getrowSize()+1; i++) {
	    int count = 0;
	    for(int j=0; j < getrowSize(); j++) {
		for(int k=0; k < getcolSize(); k++) {
		    Strimkospot temp2 = (Strimkospot)getSpot(j,k);
		    if(temp2.getStream()==i) {
			temp[count] = temp2;
			count = count + 1;
		    }
		}
	    }
	    if(!allDifferent(temp)) {
		return false;
	    }
	}
	return true;
    }

}