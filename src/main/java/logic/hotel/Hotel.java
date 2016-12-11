package logic.hotel;

import java.util.ArrayList;

import Message.ResultMessage;
import dataDao.hotel.HotelDao;
import dataDao.stub.HotelDao_Stub;
import logic.order.Order;
import logic.order.OrderHotelInfo;
import logic.utility.HotelTransform;
import logicService.hotel.CheckHotelService;
import po.HotelPO;
import vo.EvaluationVO;
import vo.HotelVO;

/**
 * 酒店信息，提供更新房间、酒店信息，获取评价，获取促销策略方法
 * @author all
 *
 */
public class Hotel implements CheckHotelService, HotelInfo, HotelTradingAreaInfo{
	
	private HotelDao hotelDao;
	private OrderHotelInfo evaluationInfo;
	
	public Hotel(){
		this.evaluationInfo = new Order();
		
		this.hotelDao = new HotelDao_Stub();
	}

	public HotelVO getHotelnfo(String hotelID) {
		return HotelTransform.hotelTransToVO(hotelDao.getHotelInfoByHotelID(hotelID));
	}

	@Override
	public String getHotelTradingArea(String hotelID) {
		HotelPO po = this.hotelDao.getHotelInfoByHotelID(hotelID);
		if(po == null) {
			return null;
		}
		return po.getTradingArea();
	}
	

	public ArrayList<EvaluationVO> getHotelEvaluations(String hotelId) {
		return evaluationInfo.getHotelEvaluations(hotelId);
	}
	
}
