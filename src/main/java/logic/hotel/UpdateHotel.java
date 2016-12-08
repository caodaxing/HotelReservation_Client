package logic.hotel;

import Message.ResultMessage;
import logic.utility.HotelTransform;
import logicService.hotel.UpdateHotelService;
import vo.HotelVO;

public class UpdateHotel implements UpdateHotelService{

	/**
	 * 更新酒店信息
	 * @param hotelVO 传入的VO信息
	 * @return ResultMessage 返回是否更新成功（成功/失败）
	 * @author all
	 */
	public ResultMessage updateHotelInfo (HotelVO hotelVO){
		if (hotelVO!=null || hotelVO.hoteID!=null ) {
			return null;
		}
		if(hotelDao.updateHotel(HotelTransform.hotelTransToPO(hotelVO))){
			return ResultMessage.SUCCESS;
		}else {
			return ResultMessage.FAILURE;
		}
	}

}
