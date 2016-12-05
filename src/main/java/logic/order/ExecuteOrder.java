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
import vo.EvaluationVO;

/**
 * 执行订单
 * @author Mark.W
 *
 */
public class ExecuteOrder implements ExecuteOrderService{
	
	private OrderDao orderDao;
	private CreditChangeInfo creditChangeInfo;
	
	
	public ExecuteOrder() {
		this.orderDao = new OrderDao_Stub();
		this.creditChangeInfo = new MockCreditChangeInfo();
	}

	@Override
	public ResultMessage normalExecute(String orderID) {
		OrderPO po = this.orderDao.getOrderByOrderID(orderID);
		
		if(po != null) {
			if(po.getState() != OrderState.EXECUTED.ordinal()) {
				po.setState(OrderState.EXECUTED.ordinal());
				
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				String executedTime=format.format(date);
				
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
		OrderPO po = this.orderDao.getOrderByOrderID(orderID);
		
		if(po != null) {
			if(po.getState() != OrderState.ABNORMAL.ordinal()) {
				po.setState(OrderState.ABNORMAL.ordinal());
				
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
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
	public ResultMessage undoAbnormalOrder(String orderID, boolean recoverAllDeletedCredit) {
		OrderPO po = this.orderDao.getOrderByOrderID(orderID);
		
		if(po != null) {
			if(po.getState() == OrderState.ABNORMAL.ordinal()) {
				po.setState(OrderState.ABNORMAL_UNDO_EXECUTED.ordinal());
				
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				String undoAbnormalTime =format.format(date);
				
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
	

	@Override
	public ResultMessage supplyOrder(String orderID) {
		return null;
	}

	@Override
	public ResultMessage evaluate(EvaluationVO evaluation) {
		
		return null;
	}

}
