package logic.hotel;

import java.rmi.RemoteException;

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
		return this.updateHotelInfo(hotelVO);
	}

	public ResultMessage updateHotelInfo(HotelVO hotelVO) {
		if (hotelVO == null || hotelVO.hoteID == null || hotelVO.hoteID == "") {
			return null;
		}
		
		try {
			
			if (hotelDao.updateHotel(HotelTransform.hotelTransToPO(hotelVO))) {
				return ResultMessage.SUCCESS;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} 
		
		return ResultMessage.FAILURE;
	}
	
	@Override
	public ResultMessage hotelIDExist(String hotelID) {
		boolean res = false;
		try {
			res = this.hotelDao.hotelIDExist(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(res){
			return ResultMessage.SUCCESS;
		} else {
			return ResultMessage.FAILURE;
		}
	}
	
	public ResultMessage hotelHasManager(String hotelID) {
		return ResultMessage.SUCCESS;
	}

}
