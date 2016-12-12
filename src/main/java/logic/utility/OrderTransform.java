package logic.utility;

import java.util.ArrayList;

import Message.OrderState;
import logic.promotion.ManagePromotion;
import logic.promotion.PromotionInfo;
import logic.room.Room;
import logic.room.RoomInfo;
import po.OrderPO;
import vo.OrderVO;
import vo.PromotionVO;
import vo.RoomVO;

public class OrderTransform {
	
	private RoomInfo roomInfo;
	private PromotionInfo promotionInfo;
	
	public OrderTransform() {
		this.roomInfo = new Room();
		
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
		
		return new OrderVO(order.getUesrID(), order.getOrderID(), order.getStartTime(), order.getEndTime(),
				order.getOrderID(),this.getRooms(order.getHotelId(), 
				order.getRoomIDs()), OrderState.values()[order.getState()],
				order.getNumberOfPeople(), order.isHasChild(), order.getBeforePromotionPrice(),
				order.getAfterPromotionPrice(), this.getPromotions(order.getPromotions()),
				order.getExecutedTime(), order.getAbnormalTime(), order.getUndoAbnormalTime(), order.getUndoUnexecutedTime());
		
	}
	

	/**
	 * 将order由vo转换为po
	 * @param ordervo
	 * @return orderpo
	 */
	public OrderPO orderTransToPO(OrderVO vo) {
		int roomNum = 0;
		ArrayList<String> roomIDs = new ArrayList<String>();
		if(vo.rooms == null) { 
			roomIDs = null;
		} else {
			for(int i=0; i<vo.rooms.size(); ++i) {
				roomIDs.add(vo.rooms.get(i).roomId);
			}
			roomNum = roomIDs.size();
		}
		
		int promotionNum = 0;
		ArrayList<String> promotionIDs = new ArrayList<String>();
		if(vo.promotions == null) {
			promotionIDs = null;
		} else {
			for(int i=0; i<vo.promotions.size(); ++i) {
				promotionIDs.add(vo.promotions.get(i).promotionID);
			}
			promotionNum = promotionIDs.size();
		}
		
		OrderPO po = new OrderPO(vo.userID, vo.orderId, vo.hotelID, vo.startTime, vo.endTime,
				roomNum, roomIDs,  vo.hasChild, vo.numOfPeople, vo.orderState.ordinal(),
				vo.beforePrice, vo.afterPrice, promotionNum, promotionIDs, vo.executedTime, 
				vo.abnormalTime, vo.undoAbnormalTime, vo.undoUnexecutedTime);
		return po;
	}
	
	private ArrayList<RoomVO> getRooms(String hotelID, ArrayList<String> roomIDs) {
		ArrayList<RoomVO> rooms = new ArrayList<RoomVO>();
		if(roomIDs == null) {
			return null;
		}
		
		for(int i=0; i<roomIDs.size(); ++i) {
			rooms.add(this.roomInfo.getRoomInfo(hotelID, roomIDs.get(i)));
		}
		
		return rooms;
	}
	
	/**
	 * 根据orderpo中的promotionID，获得promotionvo信息
	 * @param ArrayList<String> promotionIDs
	 * @return ArrayList<PromotionVO>
	 */
	private ArrayList<PromotionVO> getPromotions(ArrayList<String> promotionIDs) {
		
		if(promotionIDs == null) {
			return null;
		}
		
		ArrayList<PromotionVO> result = new ArrayList<PromotionVO>();
		
		for(int i=0; i<promotionIDs.size(); ++i) {
			result.add(promotionInfo.getPromotion(promotionIDs.get(i)));
		}
		
		return result;
	}
	
	
}
