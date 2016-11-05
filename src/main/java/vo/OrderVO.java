package vo;

public class OrderVO {
	
	String orderId;
	String startTime;
	RoomVO room;
	String endTime;
	int state;
	int numOfPeople;
	boolean hasChild;
	
	/**
	 * orderVO
	 * @param orderId 订单id
	 * @param startTime  订单开始时间
	 * @param room 房间信息
	 * @param endTime  结束时间
	 * @param state  状态
	 * @param numOfPeople  入住人数
	 * @param hasChild  有无儿童
	 */
	public OrderVO(String orderId, String startTime, RoomVO room, String endTime, 
			int state, int numOfPeople,boolean hasChild) {
		super();
		this.orderId = orderId;
		this.startTime = startTime;
		this.room = room;
		this.endTime = endTime;
		this.state = state;
		this.numOfPeople = numOfPeople;
		this.hasChild = hasChild;
	}

}
