package logic.hotel;

import java.rmi.RemoteException;

import Message.ResultMessage;
import dataDao.hotel.HotelDao;
import logic.user.HotelManager;
import logic.user.HotelManagerInfo;
import logic.utility.HotelTransform;
import logicService.hotel.UpdateHotelService;
import main.rmi.RemoteHelper;
import po.HotelPO;
import vo.HotelVO;

/**
 * 更新酒店信息
 * @author bcy
 */
public class UpdateHotel implements UpdateHotelService{

	private HotelDao hotelDao;

	public UpdateHotel() {
		this.hotelDao = RemoteHelper.getInstance().getHotelDao();
//		this.hotelDao = new HotelDao_Stub();
	}

	public ResultMessage addHotel(HotelVO hotelVO) {
		
		if(hotelVO == null) {
			return ResultMessage.FAILURE;
		}
		
		HotelPO po = HotelTransform.hotelTransToPO(hotelVO);
		
		try {
			if(this.hotelDao.addHotel(po)) {
				return ResultMessage.SUCCESS;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return ResultMessage.FAILURE;
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
		HotelManagerInfo info = new HotelManager();
		return info.hotelHasManager(hotelID);

	}

}
