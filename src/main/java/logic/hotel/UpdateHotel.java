package logic.hotel;

import Message.ResultMessage;
import dataDao.hotel.HotelDao;
import dataDao.stub.HotelDao_Stub;
import logic.utility.HotelTransform;
import logicService.hotel.UpdateHotelService;
import vo.HotelVO;

/**
 * 更新酒店信息
 * @author bcy
 */
public class UpdateHotel implements UpdateHotelService,  AddHotelInfo{

	private HotelDao hotelDao;

	public UpdateHotel() {
		this.hotelDao = new HotelDao_Stub();
	}

	public ResultMessage addHotel(HotelVO hotelVO) {
		if (hotelVO == null) {
			System.out.println("logic.hotel.UpdateHotel.addHotel参数异常");
			return null;
		}
		
		if (hotelDao.addHotel(HotelTransform.hotelTransToPO(hotelVO))) {
			return ResultMessage.SUCCESS;
		}
		return ResultMessage.FAILURE;
	}

	public ResultMessage updateHotelInfo(HotelVO hotelVO) {
		if (hotelVO == null || hotelVO.hoteID == null || hotelVO.hoteID == "") {
			return null;
		}
		
		if (hotelDao.updateHotel(HotelTransform.hotelTransToPO(hotelVO))) {
			return ResultMessage.SUCCESS;
		} 
		
		return ResultMessage.FAILURE;
	}
	
	@Override
	public ResultMessage hotelIDExist(String hotelID) {
		return this.hotelIDExist(hotelID);
	}

}
