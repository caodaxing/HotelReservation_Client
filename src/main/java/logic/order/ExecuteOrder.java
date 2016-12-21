package logic.order;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Message.CreditChangeType;
import Message.OrderState;
import Message.ResultMessage;
import Message.RoomType;
import dataDao.order.OrderDao;
import logic.credit.CreditChange;
import logic.credit.CreditChangeInfo;
import logic.room.UpdateRoom;
import logic.utility.Time;
import logicService.order.ExecuteOrderService;
import main.rmi.RemoteHelper;
import po.OrderPO;
import vo.CreditChangeVO;

/**
 * 执行订单
 * @author Mark.W
 *
 */
public class ExecuteOrder implements ExecuteOrderService{
	
	private static long SIX_HOUR = 6 * 60 * 60 * 1000;
	private OrderDao orderDao;
	private CreditChangeInfo creditChangeInfo;
	private OrderPO po;
	private UpdateRoom updateRoom;
	
	public ExecuteOrder() {
		this.creditChangeInfo = new CreditChange();
		this.updateRoom = new UpdateRoom();
		
		this.orderDao = RemoteHelper.getInstance().getOrderDao();
//		this.orderDao = new OrderDao_Stub();
	}

	@Override
	public ResultMessage hasCheckOut(String orderID) {
		
		OrderPO po = null;
		try {
			po = this.orderDao.getOrderByOrderID(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(po == null || po.getCheckOutTime() == null) {
			return ResultMessage.SUCCESS;
		}
		
		return ResultMessage.FAILURE;
	}
	
	//退房，更新order的退房时间信息
	@Override
	public ResultMessage checkOut(String orderID) {
		
		try {
			OrderPO po = this.orderDao.getOrderByOrderID(orderID);
			po.setCheckOutTime(Time.getCurrentTime());
			
			if(this.updateRoom.updateRoom(po.getHotelId(), RoomType.values()[po.getRoomType()], po.getRoomNum()) == ResultMessage.SUCCESS) {
				if(this.orderDao.updateOrder(po)) {
					return ResultMessage.SUCCESS;
				}
			}
			
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return ResultMessage.FAILURE;
	}
	
	
	public ResultMessage normalExecute(String orderID, String[] roomIDs) {
		try {
			po= this.orderDao.getOrderByOrderID(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(po != null) {
			
			if(po.getState() != OrderState.EXECUTED.ordinal()) {
				String checkInTime = Time.getCurrentTime();
				
				// 添加订单的信息
				po.setState(OrderState.EXECUTED.ordinal());
				po.setCheckInTime(checkInTime);
				po.setRoomIDs(roomIDs);
				
				try {
					if(this.orderDao.updateOrder(po)) {
						//更新信用记录和信用值
						CreditChangeVO creditChangeVO = new CreditChangeVO(po.getUesrID(), checkInTime, 
								po.getOrderID(), CreditChangeType.NORMAL_EXECUTE_ORDER_INCRESE, 
								(int)po.getAfterPromotionPrice());
						
						if(this.creditChangeInfo.changeCredit(creditChangeVO) == ResultMessage.SUCCESS){
							return ResultMessage.SUCCESS;
						} else {
							//如果更新信用记录没有成功，那么对该订单状态的改变也应该撤回
							po.setState(OrderState.UNEXECUTED.ordinal());
							po.setCheckInTime(null);
							this.orderDao.updateOrder(po);
						}
						
					}
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		}
		
		return ResultMessage.FAILURE;
	}

	@Override
	public ResultMessage supplyOrder(String orderID, String[] roomIDs) {
		
		try {
			po = this.orderDao.getOrderByOrderID(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(po !=  null) {
			if(po.getState() == OrderState.ABNORMAL.ordinal()) {
				String checkInTime = Time.getCurrentTime();
				
				// 添加订单的信息
				po.setState(OrderState.EXECUTED.ordinal());
				po.setCheckInTime(checkInTime);
				po.setRoomIDs(roomIDs);
				
				try {
					if(this.orderDao.updateOrder(po)) {
						//更新信用记录和信用值
						CreditChangeVO creditChangeVO = new CreditChangeVO(po.getUesrID(), checkInTime, 
								po.getOrderID(), CreditChangeType.SUPPLY_ABNORAML_ORDER_RECOVER, (int)po.getAfterPromotionPrice());
						
						if(this.creditChangeInfo.changeCredit(creditChangeVO) == ResultMessage.SUCCESS) {
							return ResultMessage.SUCCESS;
							
						} else {
							po.setState(OrderState.ABNORMAL.ordinal());
							po.setCheckInTime(null);
							this.orderDao.updateOrder(po);
						}
						
					}
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		}
		
		return ResultMessage.FAILURE;
	}

	
	// 撤销异常订单
	public ResultMessage undoAbnormalOrder(String orderID, boolean recoverAllDeletedCredit) {
		
		try {
			po = this.orderDao.getOrderByOrderID(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(po != null) {
			if(po.getState() == OrderState.ABNORMAL.ordinal()) {
				
				String undoAbnormalTime = Time.getCurrentTime();
				
				po.setState(OrderState.UNDOED_ABNORMAL.ordinal());
				po.setUndoAbnormalTime(undoAbnormalTime);
				
				try {
					if(this.orderDao.updateOrder(po)) {
						
						int recoverCreditNum = 0;
						
						if(recoverAllDeletedCredit) {
							recoverCreditNum = (int)po.getAfterPromotionPrice();
						} else {
							recoverCreditNum = (int)(po.getAfterPromotionPrice()/2);
						}
						
						//更新信用记录和信用值
						CreditChangeVO creditChangeVO = new CreditChangeVO(po.getUesrID(), undoAbnormalTime, 
								po.getOrderID(), CreditChangeType.SET_ABNORMAL_ORDER_DECREASE, recoverCreditNum);
						
						if(this.creditChangeInfo.changeCredit(creditChangeVO) == ResultMessage.SUCCESS){
							return ResultMessage.SUCCESS;
						} else {
							//如果更新信用记录没有成功，那么对该订单状态的改变也应该撤回
							po.setState(OrderState.ABNORMAL.ordinal());
							po.setUndoAbnormalTime(null);
							this.orderDao.updateOrder(po);
						}
					}
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		}
		
		return ResultMessage.FAILURE;
	}
		
	
	@Override
	public ResultMessage undoUnexecutedOrder(String orderID) {
	
		try {
			po = this.orderDao.getOrderByOrderID(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(po != null && po.getState() == OrderState.UNEXECUTED.ordinal()) {
			String time = Time.getCurrentTime();
			
			po.setState(OrderState.UNDOED_UNEXECUTED.ordinal());
			po.setUndoUnexecutedTime(time);
			
			
			if(this.lessThanSixHourLastestExecutedTime(time, po.getStartTime())) {
				
				if(ResultMessage.SUCCESS == this.updateRoom.updateRoomInSpecificTime(po.getHotelId(), 
						RoomType.values()[po.getRoomType()], po.getRoomNum(), po.getStartTime())) {
					try {
						if(this.orderDao.updateOrder(po)) {
							
							//更新信用记录和信用值
							CreditChangeVO creditChangeVO = new CreditChangeVO(po.getUesrID(), time, 
									po.getOrderID(), CreditChangeType.UNDO_UNEXECUTED_ORDER_DECREASE, -(int)po.getAfterPromotionPrice()/2);
							
							if(this.creditChangeInfo.changeCredit(creditChangeVO) == ResultMessage.SUCCESS) {
								
								return ResultMessage.SUCCESS;
								
							} else {
								//如果更新信用记录没有成功，那么对该订单状态的改变也应该撤回
								po.setState(OrderState.UNEXECUTED.ordinal());
								po.setUndoUnexecutedTime(null);;
								this.orderDao.updateOrder(po);
							}
						} else {
							//如果更新order数据为成功，还原更新的房间信息
							this.updateRoom.updateRoomInSpecificTime(po.getHotelId(), 
									RoomType.values()[po.getRoomType()], -po.getRoomNum(), po.getStartTime());
						}
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				} 
				
			} else {
				
				try {
					if(this.orderDao.updateOrder(po)) {
						//未执行订单撤销，房间数量要恢复
						if(ResultMessage.SUCCESS == this.updateRoom.updateRoomInSpecificTime(po.getHotelId(), 
								RoomType.values()[po.getRoomType()], po.getRoomNum(), po.getStartTime())) {
							
							return ResultMessage.SUCCESS;
						}
						
					}else {
						//如果更新信用记录没有成功，那么对该订单状态的改变也应该撤回
						po.setState(OrderState.UNEXECUTED.ordinal());
						po.setUndoUnexecutedTime(null);;
						this.orderDao.updateOrder(po);
					}
					
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
 		}
		
		return ResultMessage.FAILURE;
	}

	
	private boolean lessThanSixHourLastestExecutedTime(String time, String orderStartTime) {
		
		assert (time == null || orderStartTime == null) : "logic.order.ExecuteOrder.afterLastestExecutedTime参数错误";
		
		long l1 = 0, l2 =0;
		
		try {
			
//System.out.println("o:" + orderStartTime);
			
			//最晚订单执行时间为计划入住时间之后四小时
			String lastestExecutedTime = new Time(orderStartTime).calculateLastestExecutedTime();
			
//System.out.println("l:" + lastestExecutedTime);
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Date d1 = format.parse(time);
			Date d2 = format.parse(lastestExecutedTime);
			
			l1 = d1.getTime();
			l2 = d2.getTime();
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(l2 - l1 <  this.SIX_HOUR) {
			return true;
		}
		
		return false;
	}

	public OrderPO getPo() {
		return po;
	}

	public void setPo(OrderPO po) {
		this.po = po;
	}

	
//	public ResultMessage autoSetAbnormal(String orderID) {
//		po = this.orderDao.getOrderByOrderID(orderID);
//		
//		if(po != null) {
//			if(po.getState() != OrderState.ABNORMAL.ordinal()) {
//				po.setState(OrderState.ABNORMAL.ordinal());
//				
//				String time = Time.getCurrentTime();
//				
//				po.setAbnormalTime(time);
//				
//				if(this.orderDao.updateOrder(po)) {
//					
//					//更新信用记录和信用值
//					CreditChangeVO creditChangeVO = new CreditChangeVO(po.getUesrID(), time, 
//							po.getUesrID(), CreditChangeType.SET_ABNORMAL_ORDER_DECREASE, 
//							-(int)po.getAfterPromotionPrice());
//					
//					if(this.creditChangeInfo.changeCredit(creditChangeVO) == ResultMessage.SUCCESS){
//						return ResultMessage.SUCCESS;
//					} else {
//						//如果更新信用记录没有成功，那么对该订单状态的改变也应该撤回
//						po.setState(OrderState.UNEXECUTED.ordinal());
//						po.setAbnormalTime(null);
//						this.orderDao.updateOrder(po);
//					}
//				}
//			}
//		}
//		
//		return ResultMessage.FAILURE;
//	}
	

	
}
