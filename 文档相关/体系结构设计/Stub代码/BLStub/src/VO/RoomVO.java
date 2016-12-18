package VO;

public class RoomVO {

	int type;  //可以用enum
	int price;
	int state;  //可以用enum
	int roomId;

	public RoomVO(int type, int price, int state, int roomId) {
		super();
		this.type = type;
		this.price = price;
		this.state = state;
		this.roomId = roomId;
	}
}
