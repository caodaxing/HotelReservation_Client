package vo;

public class OrderVO {
	
	String orderId;
	String startTime;
	RoomVO room;
	String endTime;
	int state;
	int numOfPeople;
	boolean hasChild;
	
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
