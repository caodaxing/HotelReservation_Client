package logic.order;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Message.CreditChangeType;
import Message.OrderState;
import Message.ResultMessage;
import dataDao.order.OrderDao;
import dataDao.stub.OrderDao_Stub;
import logic.credit.CreditChangeInfo;
import logic.mockObject.MockCreditChangeInfo;
import logicService.order.ExecuteOrderService;
import po.OrderPO;
import vo.CreditChangeVO;

/**
 * 执行订单
 * @author Mark.W
 *
 */
public class ExecuteOrder implements ExecuteOrderService{
	
	private OrderDao orderDao;
	private CreditChangeInfo creditChangeInfo;
	private OrderList orderList;  //每次执行订单必须获得订单列表，
								//尝试使用orderlist类中的orders成员变量来减少对数据库的访问，是否考虑周全有待验证
	
	private OrderPO po;
	
	public ExecuteOrder() {
		this.orderDao = new OrderDao_Stub();
		this.creditChangeInfo = new MockCreditChangeInfo();
	}

	@Override
	public ResultMessage normalExecute(String orderID) {
		po= this.orderDao.getOrderByOrderID(orderID);
		
		if(po != null) {
			if(po.getState() != OrderState.EXECUTED.ordinal()) {
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String executedTime=format.format(date);
				
				po.setState(OrderState.EXECUTED.ordinal());
				po.setExecutedTime(executedTime);
				
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
			}
		}
		
		return ResultMessage.FAILURE;
	}

	@Override
	public ResultMessage autoSetAbnormal(String orderID) {
		po = this.orderDao.getOrderByOrderID(orderID);
		
		if(po != null) {
			if(po.getState() != OrderState.ABNORMAL.ordinal()) {
				po.setState(OrderState.ABNORMAL.ordinal());
				
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time =format.format(date);
				
				po.setAbnormalTime(time);
				
				if(this.orderDao.updateOrder(po)) {
					
					//更新信用记录和信用值
					CreditChangeVO creditChangeVO = new CreditChangeVO(po.getUesrID(), time, 
							po.getUesrID(), CreditChangeType.SET_ABNORMAL_ORDER_DECREASE, 
							-(int)po.getAfterPromotionPrice());
					
					if(this.creditChangeInfo.changeCredit(creditChangeVO) == ResultMessage.SUCCESS){
						return ResultMessage.SUCCESS;
					} else {
						//如果更新信用记录没有成功，那么对该订单状态的改变也应该撤回
						po.setState(OrderState.UNEXECUTED.ordinal());
						po.setAbnormalTime(null);
						this.orderDao.updateOrder(po);
					}
				}
			}
		}
		
		return ResultMessage.FAILURE;
	}
	
	
	@Override
	public ResultMessage supplyOrder(String orderID) {
		
		po = this.orderDao.getOrderByOrderID(orderID);
		
		if(po !=  null) {
			if(po.getState() == OrderState.ABNORMAL.ordinal()) {
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String executedTime =format.format(date);
				
				po.setState(OrderState.EXECUTED.ordinal());
				po.setExecutedTime(executedTime);
				
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
			}
		}
		
		return ResultMessage.FAILURE;
	}

	
	// 撤销异常订单
	public ResultMessage undoAbnormalOrder(String orderID, boolean recoverAllDeletedCredit) {
		po = this.orderDao.getOrderByOrderID(orderID);
		
		if(po != null) {
			if(po.getState() == OrderState.ABNORMAL.ordinal()) {
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String undoAbnormalTime =format.format(date);
				
				po.setState(OrderState.UNDOED.ordinal());
				po.setUndoAbnormalTime(undoAbnormalTime);
				
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
			}
		}
		
		return ResultMessage.FAILURE;
	}
		
	
	public OrderPO getPo() {
		return po;
	}

	public void setPo(OrderPO po) {
		this.po = po;
	}
	
}
