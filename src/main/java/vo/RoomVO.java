package vo;

public class RoomVO {

	int type;  //可以用enum
	int price;
	int state;  //可以用enum
	String roomId;

	public RoomVO(int type, int price, int state, String roomId) {
		super();
		this.type = type;
		this.price = price;
		this.state = state;
		this.roomId = roomId;
	}
}
