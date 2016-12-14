package logic.hotel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Message.RoomType;
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
		this.hotelDao = new HotelDao_Stub();
	}

	public HotelVO getHotelnfo(String hotelID) {
		HotelVO vo = null;
		try {
			vo =  HotelTransform.hotelTransToVO(hotelDao.getHotelInfoByHotelID(hotelID));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public String getHotelTradingArea(String hotelID) {
		HotelPO po = null;
		try {
			po = this.hotelDao.getHotelInfoByHotelID(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(po == null) {
			return null;
		}
		return po.getTradingArea();
	}
	

	public ArrayList<EvaluationVO> getHotelEvaluations(String hotelId) {
		this.evaluationInfo = new Order();
		
		return evaluationInfo.getHotelEvaluations(hotelId);
	}

	@Override
	public int getRoomPrice(String hotelID, RoomType roomType) {
		return 0;
	}
	
}
