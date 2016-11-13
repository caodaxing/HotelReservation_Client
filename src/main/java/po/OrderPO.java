package po;

public class OrderPO {
	String numberOfOrder;
	String startTime;
	String hotelId;
	String endTime;
	int numberOfRooms;
	boolean hasChild;
	int numberOfPeople;
	
	/**
	 * 
	 * @param numberOfOrder 订单号
	 * @param startTime 开始时间
	 * @param hotelId 酒店id
	 * @param endTime 结束时间
	 * @param numberOfRooms  房间数量
	 * @param hasChild  是否有小孩
	 * @param numberOfPeople  入住人数
	 */
	public OrderPO(String numberOfOrder,String startTime,String hotelId,
			String endTime,int numberOfRooms,boolean hasChild,int numberOfPeople) {
		super();
		this.numberOfOrder=numberOfOrder;
		this.startTime=startTime;
		this.hotelId=hotelId;
		this.endTime=endTime;
		this.numberOfRooms=numberOfRooms;
		this.hasChild=hasChild;
		this.numberOfPeople=numberOfPeople;
	}
}
