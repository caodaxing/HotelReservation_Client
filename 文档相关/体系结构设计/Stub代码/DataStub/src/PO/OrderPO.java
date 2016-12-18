package PO;

public class OrderPO {
	String numberOfOrder;
	String startTime;
	String hotelId;
	String endTime;
	int numberOfRooms;
	boolean hasChild;
	int numberOfPeople;
	
	public OrderPO(String numberOfOrder,String startTime,String hotelId,String endTime,int numberOfRooms,boolean hasChild,int numberOfPeople) {
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
