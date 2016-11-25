package Message;

public enum Identity {
	CLIENT(0), HOTELMANAGER(1), WEBMANAGER(2), WEBBUSSINESS(3);
	
	private int index;
	
	private Identity(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return this.index;
	}
}
