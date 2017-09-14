public class Kakurasu extends Puzzle {

    private int[] rowTarget;
    private int[] colTarget;

    public Kakurasu(int size, int[] r, int[] c) {
	super(size,size);
	rowTarget = r;
	colTarget = c;
	setPossibles();
	initialGrid();
    }

    public void setPossibles() {
	possibles = new int[2];
	possibles[0] =2;
	possibles[1] =1;
    }

    public int[] getrowTarget() {
	return rowTarget;
    }

    public int[] getcolTarget() {
	return colTarget;
    }
    
    public boolean checkConstraints() {

	Spot[] temp1 = new Spot[getrowSize()];
	Spot[] temp2 = new Spot[getcolSize()];
	
	for(int i=0; i<getrowSize(); i++) {
	    for(int j=0; j<getcolSize(); j++) {
		temp1[j] = getSpot(i,j);
		temp2[j] = getSpot(j,i);
	    }	    
	    if(!sumCorrect(temp1,rowTarget[i])) {
		return false;
	    }
	    if(!sumCorrect(temp2,colTarget[i])) {
		return false;
	    }
	}
	return true;		    
    }

	public boolean sumCorrect(Spot[] list, int target) {
	int sum = 0;
	for(int i=0; i < list.length; i++) {
	    if(list[i].getValue()==0)
		return true;
	    if(list[i].getValue()==1)
		sum = sum + list[i].getValue() * (i+1);
	}
	if(sum==target)
	    return true;
	return false;
    }

}