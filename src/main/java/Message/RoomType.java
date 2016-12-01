package Message;

public enum RoomType {
	SINGLE_ROOM(0), STANDARD_ROOM(1), TRIPLE_ROOM(2),  BIGBED_ROOM(3), SUITE(4);
	
	private int index;
	
	private RoomType(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
	
}
