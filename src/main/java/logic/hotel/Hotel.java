package logic.hotel;

import java.util.ArrayList;

import Message.ResultMessage;
import dataDao.HotelDao;
import dataDao.stub.HotelDao_Stub;
import logic.mockObject.MockOrderEvaluationInfo;
import logic.mockObject.MockPromotionInfo;
import logic.mockObject.MockUpdateRoomInfo;
import logic.order.OrderEvaluationInfo;
import logic.room.UpdateRoomInfo;
import logic.utility.HotelTransform;
import logicService.hotel.CheckHotelService;
import logicService.hotel.UpdateHotelService;
import vo.EvaluationVO;
import vo.HotelVO;
import vo.PromotionVO;
import vo.RoomVO;

/**
 * 酒店信息，提供更新房间、酒店信息，获取评价，获取促销策略方法
 * @author all
 *
 */
public class Hotel implements CheckHotelService, HotelInfo, HotelUpdateRoom{
	
	private HotelDao hotelDao;
	private UpdateRoomInfo updateRoomInfo;
	private MockPromotionInfo promotionInfo;
	private OrderEvaluationInfo evaluationInfo;
	
	public Hotel(){
		this.hotelDao = new HotelDao_Stub();
		this.updateRoomInfo = new MockUpdateRoomInfo();
		this.promotionInfo = new MockPromotionInfo();
		this.evaluationInfo = new MockOrderEvaluationInfo();
	}
	
	/**
	 * 酒店工作人员更新房间信息，从界面调用
	 * @param roomVO 传入的VO信息
	 * @return ResultMessage 返回是否更新成功（成功/失败）
	 * @author all
	 */
	public ResultMessage updateRoom(RoomVO roomVO){
		if (roomVO!=null || roomVO.hotelId!=null || roomVO.roomId!=null) {
			return null;
		}
		return updateRoomInfo.updateRoomInfo(roomVO);
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
