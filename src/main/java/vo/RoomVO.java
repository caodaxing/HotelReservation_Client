package vo;

public class RoomVO {

	int type; 
	int price;
	int state;
	String roomId;
	
	/**
	 * 房间的VO类
	 * @param type 房间类型
	 * @param price 房间价格
	 * @param state 房间状态
	 * @param roomId 房间Id
	 * @author Rukawa
	 */
	public RoomVO(int type, int price, int state, String roomId) {
		super();
		this.type = type;
		this.price = price;
		this.state = state;
		this.roomId = roomId;
	}
}
