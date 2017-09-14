public class Strimkospot extends Spot {

    private int stream;

    public Strimkospot(int v, int s) {
	super(v);
	stream = s;
    }

    public int getStream() {
	return stream;
    }

}