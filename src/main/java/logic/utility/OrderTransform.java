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
		if(orders == null) {
			System.out.println("logic.order.OrderList.orderTransToVO参数异常");
			return null;
		}
		
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
				order.getAfterPromotionPrice(),provo ,
				order.getCheckInTime(), order.getCheckOutTime(), order.getAbnormalTime(), order.getUndoAbnormalTime(), order.getUndoUnexecutedTime());
		
	}
	

	/**
	 * 将order由vo转换为po
	 * @param ordervo
	 * @return orderpo
	 */
	public OrderPO orderTransToPO(OrderVO vo) {
//		int roomNum = 0;
//		ArrayList<String> roomIDs = new ArrayList<String>();
//		if(vo.rooms == null) { 
//			roomIDs = null;
//		} else {
//			for(int i=0; i<vo.rooms.size(); ++i) {
//				roomIDs.add(vo.rooms.get(i).roomId);
//			}
//			roomNum = roomIDs.size();
//		}
//		
//		int promotionNum = 0;
//		ArrayList<String> promotionIDs = new ArrayList<String>();
//		if(vo.promotions == null) {
//			promotionIDs = null;
//		} else {
//			for(int i=0; i<vo.promotions.size(); ++i) {
//				promotionIDs.add(vo.promotions.get(i).promotionID);
//			}
//			promotionNum = promotionIDs.size();
//		}
		
		String promotionID = null;
		
		if(vo.promotion != null){
			promotionID = vo.promotion.promotionID;
		}
			
		
		OrderPO po = new OrderPO(vo.userID, vo.orderId, vo.hotelID, vo.startTime, vo.endTime,vo.roomIDs,
				vo.roomNum, vo.roomType.ordinal(),  vo.hasChild, vo.numOfPeople, vo.orderState.ordinal(),
				vo.beforePrice, vo.afterPrice, promotionID, vo.checkInTime, vo.checkOutTime,
				vo.abnormalTime, vo.undoAbnormalTime, vo.undoUnexecutedTime);
		return po;
	}
	

	
//	/**
//	 * 根据orderpo中的promotionID，获得promotionvo信息
//	 * @param ArrayList<String> promotionIDs
//	 * @return ArrayList<PromotionVO>
//	 */
//	private ArrayList<PromotionVO> getPromotions(ArrayList<String> promotionIDs) {
//		
//		if(promotionIDs == null) {
//			return null;
//		}
//		
//		ArrayList<PromotionVO> result = new ArrayList<PromotionVO>();
//		
//		for(int i=0; i<promotionIDs.size(); ++i) {
//			result.add(promotionInfo.getPromotion(promotionIDs.get(i)));
//		}
//		
//		return result;
//	}
//	
//	private ArrayList<RoomVO> getRooms(String hotelID, ArrayList<String> roomIDs) {
//	ArrayList<RoomVO> rooms = new ArrayList<RoomVO>();
//	if(roomIDs == null) {
//		return null;
//	}
//	
//	for(int i=0; i<roomIDs.size(); ++i) {
//		rooms.add(this.roomInfo.getRoomInfo(hotelID, roomIDs.get(i)));
//	}
//	
//	return rooms;
//}
}
