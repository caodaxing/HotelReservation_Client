package po;

import java.util.ArrayList;

/**
 * @param uesrID 用户id
 * @param orderID 订单号
 * @param startTime 开始时间
 * @param hotelId 酒店id
 * @param roomID 酒店房间号
 * @param endTime 结束时间
 * @param numberOfRooms  房间数量
 * @param hasChild  是否有小孩
 * @param numberOfPeople  入住人数
 * @param state 0:未执行 1:已执行 2:异常 3:撤销
 * @param beforePromotionPrice 促销前价格
 * @param afterPromotionPrice 促销后价格
 * @param promotionIDs 该订单使用的促销策略
 * @param executedTime 订单执行的时间 格式yyyy/MM/dd HH:mm:ss
 * @param undoAbnormalTime 订单撤销的时间 格式yyyy/MM/dd HH:mm:ss
 * @param abnormalTime 订单被置为异常的时间 格式yyyy/MM/dd HH:mm:ss	
 * @author Mark.W
 */
public class OrderPO {
	private String uesrID;
	private String orderID;
	private String startTime;
	private String hotelId;
	private ArrayList<String> roomIDs;
	private String endTime;
	private int numberOfRooms;
	private boolean hasChild;
	private int numberOfPeople;
	private int state; 
	private double beforePromotionPrice;
	private double afterPromotionPrice;
	private ArrayList<String> promotionIDs;
	private String executedTime; //订单执行的时间
	private String undoAbnormalTime;	//订单撤销的时间
	private String abnormalTime;	//订单被置为异常的时间


	public OrderPO(String userID, String orderID,String startTime,String hotelId, ArrayList<String> roomIDs,
			String endTime,int numberOfRooms,boolean hasChild,int numberOfPeople, int state,
			double beforePromotionPrice, double afterPromotionPrice, ArrayList<String> promotionIDs,
			String executedTime, String abnormalTime, String undoAbnormalTime) {
		this.uesrID = userID;
		this.orderID=orderID;
		this.startTime=startTime;
		this.hotelId=hotelId;
		this.roomIDs = roomIDs;
		this.endTime=endTime;
		this.numberOfRooms=numberOfRooms;
		this.hasChild=hasChild;
		this.numberOfPeople=numberOfPeople;
		this.state = state;
		this.beforePromotionPrice = beforePromotionPrice;
		this.afterPromotionPrice = afterPromotionPrice;
		this.promotionIDs = promotionIDs;
		this.executedTime = executedTime;
		this.abnormalTime = abnormalTime;
		this.undoAbnormalTime = undoAbnormalTime;
	}
	
	public String getUesrID() {
		return uesrID;
	}

	public void setUesrID(String uesrID) {
		this.uesrID = uesrID;
	}

	
	public ArrayList<String> getRoomIDs() {
		return roomIDs;
	}

	public void setRoomIDs(ArrayList<String> roomIDs) {
		this.roomIDs = roomIDs;
	}
	
	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public boolean isHasChild() {
		return hasChild;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;;
	}
	
	public double getBeforePromotionPrice() {
		return beforePromotionPrice;
	}

	public void setBeforePromotionPrice(double beforePromotionPrice) {
		this.beforePromotionPrice = beforePromotionPrice;
	}
	

	public double getAfterPromotionPrice() {
		return afterPromotionPrice;
	}

	public void setAfterPromotionPrice(double afterPromotionPrice) {
		this.afterPromotionPrice = afterPromotionPrice;
	}

	public ArrayList<String> getPromotions() {
		return promotionIDs;
	}

	public void setPromotions(ArrayList<String> promotions) {
		this.promotionIDs = promotions;
	}
	
	public ArrayList<String> getPromotionIDs() {
		return promotionIDs;
	}

	public void setPromotionIDs(ArrayList<String> promotionIDs) {
		this.promotionIDs = promotionIDs;
	}

	public String getExecutedTime() {
		return executedTime;
	}

	public void setExecutedTime(String executedTime) {
		this.executedTime = executedTime;
	}

	public String getUndoAbnormalTime() {
		return undoAbnormalTime;
	}

	public void setUndoAbnormalTime(String undoAbnormalTime) {
		this.undoAbnormalTime = undoAbnormalTime;
	}
	
	public String getAbnormalTime() {
		return abnormalTime;
	}

	public void setAbnormalTime(String abnormalTime) {
		this.abnormalTime = abnormalTime;
	}
}
