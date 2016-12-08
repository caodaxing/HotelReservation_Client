package logic.hotel;

import Message.ResultMessage;
import dataDao.HotelDao;
import dataDao.stub.HotelDao_Stub;
import logic.mockObject.MockUpdateRoomInfo;
import logic.room.UpdateRoomInfo;
import logic.utility.HotelTransform;
import logicService.hotel.UpdateHotelService;
import vo.HotelVO;
import vo.RoomVO;

public class UpdateHotel implements UpdateHotelService ,HotelUpdateRoom{

	HotelDao hotelDao;
	UpdateRoomInfo updateRoomInfo;
	
	public UpdateHotel() {
		this.hotelDao = new HotelDao_Stub();
		this.updateRoomInfo = new MockUpdateRoomInfo();
	}
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
}
