package vo;


import Message.OrderState;
import Message.RoomType;

/**
 * @param userID 用户id
 * @param orderid 订单id
 * @param roomType
 * @param roomNum
 * @param startTime  订单开始时间(预计入住时间)
 * @param endTime  结束时间(预计退房时间)
 * @param hotelID 酒店id
 * @param orderState 状态 默认为未执行
 * @param numOfPeople
 * @param hasChild 入住人数
 * @param beforePrice 优惠前价格
 * @param afterPrice 优惠后价格
 * @param promotions 订单时候的促销信息
 * @param executedTime 订单执行的时间 格式yyyy/MM/dd HH:mm:ss
 * @param undoAbnormalTime 异常订单撤销的时间 格式yyyy/MM/dd HH:mm:ss
 * @param abnormalTime 订单被置为异常的时间 格式yyyy/MM/dd HH:mm:ss	
 * @param undoUnexecutedTime 未执行订单被用户撤销的时间 格式yyyy/MM/dd HH:mm:ss
 */
public class OrderVO {
	
	public String userID;
	public String orderId;
	public RoomType roomType;
	public int roomNum;
	public String startTime;
	public String endTime;
	public String hotelID;
	public OrderState orderState = OrderState.UNEXECUTED;
	public int numOfPeople;
	public boolean hasChild;
	public double beforePrice;
	public double afterPrice;
	public PromotionVO promotion;
	public String executedTime; 
	public String undoAbnormalTime;	
	public String abnormalTime;	
	public String undoUnexecutedTime;	
	
	/**
	 * 生成订单调用时给view层用的构造方法
	 * @param userID
	 * @param roomType
	 * @param roomNum
	 * @param startTime
	 * @param endTime
	 * @param hotelID
	 * @param numOfPeople
	 * @param hasChild
	 */
	public OrderVO(String userID,  RoomType roomType, int roomNum, String startTime, String endTime,
			String hotelID, int numOfPeople, boolean hasChild) {
		this.userID = userID;
		this.roomType = roomType;
		this.roomNum = roomNum;
		this.startTime = startTime;
		this.hotelID = hotelID;
		this.endTime = endTime;
		this.numOfPeople = numOfPeople;
		this.hasChild = hasChild;
	}

	/**
	 * ui获得订单信息时候，logic层用的构造方法
	 * @param userID
	 * @param orderId
	 * @param roomType
	 * @param roomNum
	 * @param startTime
	 * @param endTime
	 * @param hotelID
	 * @param orderState
	 * @param numOfPeople
	 * @param hasChild
	 * @param beforePrice
	 * @param afterPrice
	 * @param promotions
	 * @param executedTime
	 * @param undoAbnormalTime
	 * @param abnormalTime
	 * @param undoUnexecutedTime
	 */
	public OrderVO(String userID, String orderId, RoomType roomType, int roomNum, String startTime, String endTime,
			String hotelID, OrderState orderState, int numOfPeople, boolean hasChild, double beforePrice,
			double afterPrice, PromotionVO promotion, String executedTime, String undoAbnormalTime,
			String abnormalTime, String undoUnexecutedTime) {
		this.userID = userID;
		this.orderId = orderId;
		this.roomType = roomType;
		this.roomNum = roomNum;
		this.startTime = startTime;
		this.endTime = endTime;
		this.hotelID = hotelID;
		this.orderState = orderState;
		this.numOfPeople = numOfPeople;
		this.hasChild = hasChild;
		this.beforePrice = beforePrice;
		this.afterPrice = afterPrice;
		this.promotion = promotion;
		this.executedTime = executedTime;
		this.undoAbnormalTime = undoAbnormalTime;
		this.abnormalTime = abnormalTime;
		this.undoUnexecutedTime = undoUnexecutedTime;
	}
	
	
	
}
