package logic.hotel;

import java.util.ArrayList;

import dataDao.HotelDao;
import dataDao.stub.HotelDao_Stub;
import logic.mockObject.MockOrderHotelInfo;
import logic.mockObject.MockPromotionInfo;
import logic.mockObject.MockUpdateRoomInfo;
import logic.order.OrderHotelInfo;
import logic.promotion.PromotionInfo;
import logic.room.UpdateRoomInfo;
import logic.utility.HotelTransform;
import logicService.hotel.CheckHotelService;
import vo.EvaluationVO;
import vo.HotelVO;
import vo.PromotionVO;

/**
 * 酒店信息，提供更新房间、酒店信息，获取评价，获取促销策略方法
 * @author all
 *
 */
public class Hotel implements CheckHotelService, HotelInfo{
	
	private HotelDao hotelDao;
	private UpdateRoomInfo updateRoomInfo;
	private PromotionInfo promotionInfo;
	private OrderHotelInfo evaluationInfo;
	
	public Hotel(){
		this.hotelDao = new HotelDao_Stub();
		this.updateRoomInfo = new MockUpdateRoomInfo();
		this.promotionInfo = new MockPromotionInfo();
		this.evaluationInfo = new MockOrderHotelInfo();
	}
	
	/**
	 * 获取促销策略
	 * @param hotel_id 传入的酒店id
	 * @return String 返回酒店的促销策略
	 * @author all
	 */
	public PromotionVO getPromotion(String hotel_id){
		return promotionInfo.getPromotion(hotel_id);
	}

	/**
	 * 给order提供的获取酒店信息的接口
	 * @param hotel_id 传入的酒店id
	 * @return HotelVO 返回部分酒店信息
	 * @author all
	 */
	public HotelVO getHotelnfo(String hotel_id) {
		return HotelTransform.hotelTransToVO(hotelDao.getHotelInfoByHotelID(hotel_id));
	}

	/**
	 * 获取酒店评价信息
	 * @param hotelId 传入的酒店id
	 * @return ArrayList<EvaluationVO> 返回评价的列表
	 * @author all
	 */
	public ArrayList<EvaluationVO> getHotelEvaluations(String hotelId) {
		return evaluationInfo.getHotelEvaluations(hotelId);
	}
}
