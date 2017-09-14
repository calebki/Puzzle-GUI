public class Spot {

    private int value;
    
    public Spot(int v) {
	value = v;
    }

    public int getValue() {
	return value;
    }

    public void setValue(int v) {
	value = v;
    }

    public boolean checkLabeled() {
	if(getValue() == 0) {
	    return false;
	}
	
	return true;
    }
}