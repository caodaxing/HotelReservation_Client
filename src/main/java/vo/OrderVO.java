package vo;

import java.util.ArrayList;

import Message.OrderState;

/**
 * @param orderId 订单id
 * @param startTime  订单开始时间
 * @param endTime  结束时间
 * @param room 房间信息
 * @param orderState 状态
 * @param numOfPeople
 * @param hasChild 入住人数
 * @param beforePrice 优惠前价格
 * @param afterPrice 优惠后价格
 * @param promotions 订单时候的促销信息
 */
public class OrderVO {
	
	public String orderId;
	public String startTime;
	public RoomVO room;
	public String endTime;
	public OrderState orderState;
	public int numOfPeople;
	public boolean hasChild;
	public double beforePrice;
	public double afterPrice;
	public ArrayList<PromotionVO> promotions;
	
	public OrderVO(String orderId, String startTime, String endTime, RoomVO room, OrderState orderState,
			int numOfPeople, boolean hasChild, double beforePrice, double afterPrice, ArrayList<PromotionVO> promotions) {
		this.orderId = orderId;
		this.startTime = startTime;
		this.room = room;
		this.endTime = endTime;
		this.orderState = orderState;
		this.numOfPeople = numOfPeople;
		this.hasChild = hasChild;
		this.beforePrice = beforePrice;
		this.afterPrice = afterPrice;
		this.promotions = promotions;
	}
	
	
	 

}
