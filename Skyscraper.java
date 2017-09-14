public class Skyscraper extends Puzzle {
    
    private int[] viewFromRight;
    private int[] viewFromLeft;
    private int[] viewFromTop;
    private int[] viewFromBottom;

    public Skyscraper(int size, int[] r, int[] l, int[] t, int[] b) {
	super(size,size);
	setPossibles();
	initialGrid();
	viewFromRight = r;
	viewFromLeft = l;
	viewFromTop = t;
	viewFromBottom = b;
    }

    public Skyscraper(int size, int[] r, int[] l, int[] t, int[] b, int[] alreadySet) {
	super(size,size);
	setPossibles();
	initialGrid(alreadySet);
	viewFromRight = r;
	viewFromLeft = l;
	viewFromTop = t;
	viewFromBottom = b;
    }

    public void initialGrid(int[]needSetting) {
	for(int i=0; i < getrowSize(); i++) {
	    for(int j=0; j < getcolSize(); j++) {
		Spot temp = new Spot(0);
		grid[i][j] = temp;
	    }
	}
	for(int i=0; i<needSetting.length; i=i+3) {
	    setSpot(needSetting[i],needSetting[i+1],needSetting[i+2]);
	}
    }


    public int[] getviewFromRight() {
	return viewFromRight;
    }

    public int[] getviewFromLeft() {
	return viewFromLeft;
    }

    public int[] getviewFromTop() {
	return viewFromTop;
    }

    public int[] getviewFromBottom() {
	return viewFromBottom;
    }

    public boolean canCheckView(Spot[] x) {
	for(int i=0; i<x.length; i++) {
	    if(x[i].getValue()==0) {
		return false;
	    }
	}
	return true;
    }

    public boolean checkConstraints() {	    
	if(!latinSquare())
	    return false;

	Spot[] temp1 = new Spot[getrowSize()];
	Spot[] temp2 = new Spot[getrowSize()];
	Spot[] temp3 = new Spot[getcolSize()];
	Spot[] temp4 = new Spot[getcolSize()];

	for(int i=0; i<getrowSize(); i++) {
	    for(int j=0; j<getcolSize(); j++) {
		temp1[j] = getSpot(i,j);
		temp2[getrowSize()-1-j] = getSpot(i,j);
		temp3[j] = getSpot(j,i);
		temp4[getrowSize()-1-j] = getSpot(j,i);
	    }
	    if(!correctView(temp1,viewFromLeft[i])) {
		return false;
	    }
	    
	    if(!correctView(temp2,viewFromRight[i])) {
		return false;
	    }
	    
	    if(!correctView(temp3,viewFromTop[i])) {
		return false;
	    }
	    
	    if(!correctView(temp4,viewFromBottom[i])) {
		return false;
	    }
	    	    
	}
	return true;
    }

    public boolean correctView(Spot[] list, int view) {
	int buildingsSeen = 1;
	int temp;
	if(list[0].getValue()==0) 
	    return true;
	else
	    temp = list[0].getValue();	
	for(int i=1; i < list.length; i++) {
	    if(list[i].getValue() == 0) {
		return true;
	    }
	    if(list[i].getValue() > temp) {
		temp = list[i].getValue();
		buildingsSeen = buildingsSeen + 1;
	    }	    
	}
	if(buildingsSeen == view) 
	    return true;
	return false;
    }
			   
}
    

    