package logic.order;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Message.ResultMessage;
import dataDao.order.OrderDao;
import dataDao.stub.OrderDao_Stub;
import logic.utility.EvaluationTransform;
import logic.utility.OrderTransform;
import logicService.order.OrderService;
import po.EvaluationPO;
import po.OrderPO;
import vo.EvaluationVO;
import vo.OrderVO;

/**
 * 订单处理类
 * @author Mark.W
 *
 */
public class Order implements OrderService, OrderHotelInfo{
	
	private OrderDao orderDao;
	private EvaluationTransform evaluationTrans;
	private OrderTransform orderTrans;
	
	public Order() {
		this.evaluationTrans = new EvaluationTransform();
		this.orderTrans = new OrderTransform();
		this.orderDao = new OrderDao_Stub();
	}

	@Override
	public EvaluationVO getEvaluationInfo(String orderID) {
		EvaluationPO po = null;
		try {
			po = this.orderDao.getEvaluationByOrderID(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return this.evaluationTrans.evalutionTransToVO(po);
	}

	@Override
	public OrderVO getOrderInfo(String orderID) {
		OrderPO po = null;
		try {
			po = this.orderDao.getOrderByOrderID(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return this.orderTrans.orderTransToVO(po);
		
	}
	
	@Override
	public ResultMessage evaluate(EvaluationVO evaluation) {
		
		if(evaluation != null) {
			EvaluationPO po = this.evaluationTrans.evalutionTransToPO(evaluation);
			try {
				if(this.orderDao.addEvaluation(po)) {
					return ResultMessage.SUCCESS;
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		
		return ResultMessage.FAILURE;
	}

	@Override
	public ArrayList<EvaluationVO> getHotelEvaluations(String hotelID) {
		
		ArrayList<EvaluationPO> res = null;
		try {
			res = this.orderDao.getEvaluationByHotelID(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return this.evaluationTrans.evalutionListTransToVO(res);
	}

	@Override
	public ArrayList<String> getBookedHotelList(String userID) {
		ArrayList<String> res = null;
		
		try {
			res =  this.orderDao.getBookedHotelList(userID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return res;
	}

}


