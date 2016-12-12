package logic.hotel;

public class Down implements UpOrDownSort {

	@Override
	public boolean compare(double a, double b) {
		if(a <= b) {
			return true;
		}
		return false;
	}

}
