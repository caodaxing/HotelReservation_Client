package logic.order;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Message.ResultMessage;
import dataDao.order.OrderDao;
import logic.hotel.CheckHotel;
import logic.hotel.HotelInfo;
import logic.utility.DataFormat;
import logic.utility.EvaluationTransform;
import logic.utility.OrderTransform;
import logicService.order.OrderService;
import main.rmi.RemoteHelper;
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
		
		this.orderDao = RemoteHelper.getInstance().getOrderDao();
//		this.orderDao = new OrderDao_Stub();
	}
	

	@Override
	public OrderVO getOrderInfo(String orderID) {
		OrderPO po = null;
		try {
			po = this.orderDao.getOrderByOrderID(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		OrderVO vo = this.orderTrans.orderTransToVO(po);
		return vo;
		
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
	public ResultMessage evaluate(EvaluationVO evaluation) {
		
		if(evaluation != null) {
			EvaluationPO po = this.evaluationTrans.evalutionTransToPO(evaluation);
			try {
				if(this.orderDao.addEvaluation(po)) {
					
					if(this.updateHotelGrade(evaluation)) {
						return ResultMessage.SUCCESS;
					}
					
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		
		return ResultMessage.FAILURE;
	}

	//更新酒店评分信息
	private boolean updateHotelGrade(EvaluationVO evaluation) {
		OrderPO po = null;
		try {
			po = this.orderDao.getOrderByOrderID(evaluation.orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		ArrayList<EvaluationVO> evaluationVOs = this.getHotelEvaluations(po.getHotelId());
		
		double grade = 0;
		for(int i=0; i<evaluationVOs.size(); ++i) {

			double temp = evaluationVOs.get(i).commentLevel;

			grade += temp; 
		}
		
		grade /= evaluationVOs.size();
		grade = DataFormat.formatDouble(grade);
		
		HotelInfo hotelInfo = new CheckHotel();
		if(hotelInfo.updateHotelGrade(po.getHotelId(), grade)) {
			return true;
		}
		
		return false;
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
	
	
//	public ResultMessage updateOrder(OrderVO vo) {
//		if(vo != null) {
//			OrderPO po = this.orderTrans.orderTransToPO(vo);
//			
//			try {
//				if(this.orderDao.updateOrder(po)) {
//					return ResultMessage.SUCCESS;
//				}
//			} catch (RemoteException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return ResultMessage.SUCCESS;
//	}
}


