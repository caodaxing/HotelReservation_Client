package logic.order;

import java.util.ArrayList;

import Message.ResultMessage;
import dataDao.order.OrderDao;
import dataDao.order.OrderListDao;
import dataDao.stub.OrderDao_Stub;
import dataDao.stub.OrderListDao_Stub;
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
		EvaluationPO po = this.orderDao.getEvaluationByOrderID(orderID);
		return this.evaluationTrans.evalutionTransToVO(po);
	}

	@Override
	public OrderVO getOrderInfo(String orderID) {
		OrderPO po = this.orderDao.getOrderByOrderID(orderID);
		return this.orderTrans.orderTransToVO(po);
		
	}
	
	@Override
	public ResultMessage evaluate(EvaluationVO evaluation) {
		
		if(evaluation != null) {
			EvaluationPO po = this.evaluationTrans.evalutionTransToPO(evaluation);
			if(this.orderDao.addEvalution(po)) {
				return ResultMessage.SUCCESS;
			}
		}
		
		return ResultMessage.FAILURE;
	}

	@Override
	public ArrayList<EvaluationVO> getHotelEvaluations(String hotelID) {
		
		return this.evaluationTrans.evalutionListTransToVO(this.orderDao.getEvaluationByHotelID(hotelID));
	}

	@Override
	public ArrayList<String> getBookedHotelList(String userID) {
		return this.orderDao.getBookedHotelList(userID);
	}

}


