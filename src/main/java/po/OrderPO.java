package po;

import java.util.ArrayList;

/**
 * @param numberOfOrder 订单号
 * @param startTime 开始时间
 * @param hotelId 酒店id
 * @param endTime 结束时间
 * @param numberOfRooms  房间数量
 * @param hasChild  是否有小孩
 * @param numberOfPeople  入住人数
 * @param state 0:未执行 1:已执行 2:异常 3:撤销
 * @param beforePromotionPrice 促销前价格
 * @param afterPromotionPrice 促销后价格
 * @param promotions 该订单使用的促销策略
 * @author Mark.W
 */
public class OrderPO {
	private String numberOfOrder;
	private String startTime;
	private String hotelId;
	private String endTime;
	private int numberOfRooms;
	private boolean hasChild;
	private int numberOfPeople;
	private int state; 
	private double beforePromotionPrice;
	private double afterPromotionPrice;
	private ArrayList<String> promotions;


	public OrderPO(String numberOfOrder,String startTime,String hotelId,
			String endTime,int numberOfRooms,boolean hasChild,int numberOfPeople, int state,
			double beforePromotionPrice, double afterPromotionPrice, ArrayList<String> promotions) {
		this.numberOfOrder=numberOfOrder;
		this.startTime=startTime;
		this.hotelId=hotelId;
		this.endTime=endTime;
		this.numberOfRooms=numberOfRooms;
		this.hasChild=hasChild;
		this.numberOfPeople=numberOfPeople;
		this.state = state;
		this.beforePromotionPrice = beforePromotionPrice;
		this.afterPromotionPrice = afterPromotionPrice;
		this.promotions = promotions;
	}
	
	public String getNumberOfOrder() {
		return numberOfOrder;
	}

	public void setNumberOfOrder(String numberOfOrder) {
		this.numberOfOrder = numberOfOrder;
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
		return promotions;
	}

	public void setPromotions(ArrayList<String> promotions) {
		this.promotions = promotions;
	}
}
