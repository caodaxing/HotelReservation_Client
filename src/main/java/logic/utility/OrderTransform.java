package logic.utility;

import java.util.ArrayList;

import Message.OrderState;
import Message.RoomType;
import logic.promotion.ManagePromotion;
import logic.promotion.PromotionInfo;
import po.OrderPO;
import vo.OrderVO;
import vo.PromotionVO;

public class OrderTransform {
	
	private PromotionInfo promotionInfo;
	
	public OrderTransform() {
		
		this.promotionInfo = new ManagePromotion();
	}

	/**
	 * 将orderlist由po转换为vo
	 * @param orders po
	 * @return orders vo
	 */
	public ArrayList<OrderVO> orderListTransToVO(ArrayList<OrderPO> orders) {
		assert orders == null :"logic.order.OrderList.orderTransToVO参数异常";
		
		ArrayList<OrderVO> result = new ArrayList<OrderVO>();
		
		for(int i=0; i<orders.size(); ++i) {
			result.add(this.orderTransToVO(orders.get(i)));
		}
		
		return result;
	}
	
	/**
	 * 将order由po转换为vo
	 * @param orderpo
	 * @return ordervo
	 */
	public OrderVO orderTransToVO(OrderPO order) {
		if(order == null) {
			return null;
		}
		
		PromotionVO provo = this.promotionInfo.getPromotion(order.getPromotionID());
		
		return new OrderVO(order.getUesrID(), order.getOrderID(),RoomType.values()[order.getRoomType()], order.getRoomIDs(), order.getRoomNum(),
				order.getStartTime(), order.getEndTime(), order.getHotelId(), OrderState.values()[order.getState()],
				order.getNumberOfPeople(), order.isHasChild(), order.getBeforePromotionPrice(),
				order.getAfterPromotionPrice(),provo, order.getCheckInTime(), order.getCheckOutTime(), order.getUndoAbnormalTime(),order.getAbnormalTime(),  order.getUndoUnexecutedTime());
		
	}
	

	/**
	 * 将order由vo转换为po
	 * @param ordervo
	 * @return orderpo
	 */
	public OrderPO orderTransToPO(OrderVO vo) {
		String promotionID = null;
		
		if(vo.promotion != null){
			promotionID = vo.promotion.promotionID;
		}
			
		
		OrderPO po = new OrderPO(vo.userID, vo.orderId, vo.hotelID, vo.startTime, vo.endTime,vo.roomIDs,
				vo.roomNum, vo.roomType.ordinal(),  vo.hasChild, vo.numOfPeople, vo.orderState.ordinal(),
				vo.beforePrice, vo.afterPrice, promotionID, vo.checkInTime, vo.checkOutTime,
				 vo.undoAbnormalTime, vo.abnormalTime,vo.undoUnexecutedTime);
		return po;
	}
}
