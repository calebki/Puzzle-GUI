public class KenKen extends Puzzle {

    private int[] boxTarget;
    private String[] boxOps;
    private int[] boxSetup;

    public KenKen(int size, int[] boxLayout, int[] t,  String[] bo) {
	super(size,size);
	boxTarget=t;
	boxOps = bo;
	setPossibles();
	boxSetup = boxLayout;
	initialGrid();
    }

    public void initialGrid() {
	for(int i=0; i < getrowSize(); i++) {
	    for(int j=0; j < getcolSize(); j++) {
		int temp1 = boxSetup[i*getrowSize()+j];
		KenKenspot temp = new KenKenspot(0,temp1);
		grid[i][j] = temp;
	    }
	}
    }

    public int[] getboxTarget() {
	return boxTarget;
    }

    public String[] getboxOps() {
	return boxOps;
    }

    public boolean checkConstraints() {
	if(latinSquare())
	    return operationsCorrect();

	return false;
    }

    public boolean operationsCorrect() {
	for(int i=1; i < boxTarget.length; i++) {
	    Spot[] temp = new Spot[getrowSize()*getrowSize()];
	    int count = 0;
	    for(int j=0; j < getrowSize(); j++) {
		for(int k=0; k<getcolSize(); k++) {
		    KenKenspot temp2 = (KenKenspot)getSpot(j,k);
		    if(temp2.getBox()==i) {
			temp[count] = temp2;
			count = count + 1;
		    }
		}
	    }
	    if(!helperOperationsCorrect(temp,i-1)) {
		return false;
	    }
	}
	return true;
    }

    public boolean helperOperationsCorrect(Spot[] box, int boxNO) {
	if(boxOps[boxNO].equals("/")) {
	    if(box[1]==null)
		return true;
	    if(box[0].getValue()==0 || box[1].getValue()==0)
		return true;
	    if(box[0].getValue()/box[1].getValue()==boxTarget[boxNO] || box[1].getValue()/box[0].getValue()==boxTarget[boxNO])
		return true;
	}

	if(boxOps[boxNO].equals("-")) {
	    if(box[1]==null)
		return true;
	    if(box[0].getValue()==0 || box[1].getValue()==0)
		return true;
	    if(box[0].getValue()-box[1].getValue()==boxTarget[boxNO] || box[1].getValue()-box[0].getValue()==boxTarget[boxNO])
		return true;
	}

	if(boxOps[boxNO].equals("*")) {
	    int product  = 1;
	    for(int i=0; i<box.length; i++) {
		if(box[i].getValue()==0)
		    return true;
		product = product * box[i].getValue();
		if(box.length-1 != i) {
		    if(box[i+1]==null)
			break;
		}
	    }
	    if(product == boxTarget[boxNO])
		return true;
	}

	if(boxOps[boxNO].equals("+")) {
	    int sum = 0;
	    for(int i=0; i<box.length; i++) {
		if(box[i].getValue()==0)
		    return true;
		sum = sum + box[i].getValue();
		if(box.length-1 != i) {
		    if(box[i+1]==null)
			break;
		}
	    }
	    if(sum == boxTarget[boxNO])
		return true;
	}
	return false;
	
    }


}
