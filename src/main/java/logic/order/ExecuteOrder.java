package logic.order;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Message.CreditChangeType;
import Message.OrderState;
import Message.ResultMessage;
import dataDao.order.OrderDao;
import dataDao.stub.OrderDao_Stub;
import logic.credit.CreditChange;
import logic.credit.CreditChangeInfo;
import logic.utility.Time;
import logicService.order.ExecuteOrderService;
import po.OrderPO;
import vo.CreditChangeVO;

/**
 * 执行订单
 * @author Mark.W
 *
 */
public class ExecuteOrder implements ExecuteOrderService{
	
	private long sixHours = 6 * 60 * 60 * 1000;
	private OrderDao orderDao;
	private CreditChangeInfo creditChangeInfo;
//	private OrderList orderList;  //每次执行订单必须获得订单列表，
//								//尝试使用orderlist类中的orders成员变量来减少对数据库的访问，是否考虑周全有待验证
//	
	private OrderPO po;
	
	public ExecuteOrder() {
		this.creditChangeInfo = new CreditChange();
		
		this.orderDao = new OrderDao_Stub();
	}

	@Override
	public ResultMessage normalExecute(String orderID) {
		try {
			po= this.orderDao.getOrderByOrderID(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(po != null) {
			if(po.getState() != OrderState.EXECUTED.ordinal()) {
				String executedTime = Time.getCurrentTime();
				
				po.setState(OrderState.EXECUTED.ordinal());
				po.setExecutedTime(executedTime);
				
				try {
					if(this.orderDao.updateOrder(po)) {
						//更新信用记录和信用值
						CreditChangeVO creditChangeVO = new CreditChangeVO(po.getUesrID(), executedTime, 
								po.getUesrID(), CreditChangeType.NORMAL_EXECUTE_ORDER_INCRESE, 
								(int)po.getAfterPromotionPrice());
						
						if(this.creditChangeInfo.changeCredit(creditChangeVO) == ResultMessage.SUCCESS){
							return ResultMessage.SUCCESS;
						} else {
							//如果更新信用记录没有成功，那么对该订单状态的改变也应该撤回
							po.setState(OrderState.UNEXECUTED.ordinal());
							po.setExecutedTime(null);
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
	public ResultMessage supplyOrder(String orderID) {
		
		try {
			po = this.orderDao.getOrderByOrderID(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(po !=  null) {
			if(po.getState() == OrderState.ABNORMAL.ordinal()) {
				String executedTime = Time.getCurrentTime();
				
				po.setState(OrderState.EXECUTED.ordinal());
				po.setExecutedTime(executedTime);
				
				try {
					if(this.orderDao.updateOrder(po)) {
						//更新信用记录和信用值
						CreditChangeVO creditChangeVO = new CreditChangeVO(po.getUesrID(), executedTime, 
								po.getUesrID(), CreditChangeType.SUPPLY_ABNORAML_ORDER_RECOVER, (int)po.getAfterPromotionPrice());
						
						if(this.creditChangeInfo.changeCredit(creditChangeVO) == ResultMessage.SUCCESS) {
							return ResultMessage.SUCCESS;
							
						} else {
							po.setState(OrderState.ABNORMAL.ordinal());
							po.setExecutedTime(null);
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
								po.getUesrID(), CreditChangeType.SET_ABNORMAL_ORDER_DECREASE, recoverCreditNum);
						
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
			po.setUndoUnexecutedTime(time);;
			if(this.lessThanSixHourLastestExecutedTime(time, po.getStartTime())) {
System.out.println("b");
				try {
					if(this.orderDao.updateOrder(po)) {
						//更新信用记录和信用值
						CreditChangeVO creditChangeVO = new CreditChangeVO(po.getUesrID(), time, 
								po.getUesrID(), CreditChangeType.UNDO_UNEXECUTED_ORDER_DECREASE, -(int)po.getAfterPromotionPrice()/2);
						
						if(this.creditChangeInfo.changeCredit(creditChangeVO) == ResultMessage.SUCCESS){
							return ResultMessage.SUCCESS;
						} else {
							//如果更新信用记录没有成功，那么对该订单状态的改变也应该撤回
							po.setState(OrderState.UNEXECUTED.ordinal());
							po.setUndoUnexecutedTime(null);;
							this.orderDao.updateOrder(po);
						}
					}
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			} else {
System.out.println("c");
				try {
					if(this.orderDao.updateOrder(po)) {
						return ResultMessage.SUCCESS;
					}
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
 		}
		
		return ResultMessage.FAILURE;
	}

	
	private boolean lessThanSixHourLastestExecutedTime(String time, String orderStartTime) {
		
		if(time == null || orderStartTime == null) {
System.out.println("logic.order.ExecuteOrder.afterLastestExecutedTime参数错误");
			return false;
		}
		
		long l1 = 0, l2 =0;
		
		try {
			String lastestExecutedTime = new Time(orderStartTime).calculateLastestExecutedTime();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Date d1 = format.parse(time);
			Date d2 = format.parse(lastestExecutedTime);
			
			l1 = d1.getTime();
			l2 = d2.getTime();
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(l2 - l1 <  this.sixHours) {
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
