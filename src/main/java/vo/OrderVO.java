package vo;

import java.util.ArrayList;

import Message.OrderState;

/**
 * @param userID 用户id
 * @param orderId 订单id
 * @param startTime  订单开始时间
 * @param endTime  结束时间
 * @param hotelID 酒店id
 * @param room 房间信息
 * @param orderState 状态
 * @param numOfPeople
 * @param hasChild 入住人数
 * @param beforePrice 优惠前价格
 * @param afterPrice 优惠后价格
 * @param promotions 订单时候的促销信息
 * @param executedTime 订单执行的时间
 * @param undoAbnormalTime 订单撤销的时间
 * @param abnormalTime 订单被置为异常的时间
 */
public class OrderVO {
	
	public String userID;
	public String orderId;
	public String startTime;
	public ArrayList<RoomVO> rooms;
	public String endTime;
	public String hotelID;
	public OrderState orderState;
	public int numOfPeople;
	public boolean hasChild;
	public double beforePrice;
	public double afterPrice;
	public ArrayList<PromotionVO> promotions;
	public String executedTime; 
	public String undoAbnormalTime;	
	public String abnormalTime;	
	
	/**
	 * 生成订单调用时给view层用的构造方法
	 * @param userID
	 * @param startTime
	 * @param endTime
	 * @param hotelID
	 * @param rooms
	 * @param numOfPeople
	 * @param hasChild
	 * @param beforePrice
	 */
	public OrderVO(String userID, String startTime, String endTime,String hotelID, 
			ArrayList<RoomVO> rooms, int numOfPeople, boolean hasChild, double beforePrice) {
		this.userID = userID;
		this.startTime = startTime;
		this.rooms = rooms;
		this.hotelID = hotelID;
		this.endTime = endTime;
		this.numOfPeople = numOfPeople;
		this.hasChild = hasChild;
		this.beforePrice = beforePrice;
	}
	
	/**
	 * ui获得订单信息时候，logic层用的构造方法
	 * @param userID
	 * @param orderId
	 * @param startTime
	 * @param endTime
	 * @param hotelID
	 * @param rooms
	 * @param orderState
	 * @param numOfPeople
	 * @param hasChild
	 * @param beforePrice
	 * @param afterPrice
	 * @param promotions
	 * @param executedTime
	 * @param undoAbnormalTime
	 * @param abnormalTime
	 */
	public OrderVO(String userID,String orderId, String startTime, String endTime,String hotelID, 
			ArrayList<RoomVO> rooms, OrderState orderState,
			int numOfPeople, boolean hasChild, double beforePrice, 
			double afterPrice, ArrayList<PromotionVO> promotions,String executedTime,
			String undoAbnormalTime, String abnormalTime) {
		
		this.userID = userID;
		this.orderId = orderId;
		this.startTime = startTime;
		this.rooms = rooms;
		this.hotelID = hotelID;
		this.endTime = endTime;
		this.orderState = orderState;
		this.numOfPeople = numOfPeople;
		this.hasChild = hasChild;
		this.beforePrice = beforePrice;
		this.afterPrice = afterPrice;
		this.promotions = promotions;
		this.executedTime = executedTime;
		this.undoAbnormalTime = undoAbnormalTime;
		this.abnormalTime = abnormalTime;
	}
	
}
