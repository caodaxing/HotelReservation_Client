package logic.user;

import java.rmi.RemoteException;

import Message.ResultMessage;
import dataDao.user.HotelManagerDao;
import logic.utility.HotelManagerTransform;
import logicService.user.HotelManagerService;
import main.rmi.RemoteHelper;
import po.HotelManagerPO;
import vo.HotelManagerVO;

public class HotelManager implements HotelManagerService, HotelManagerInfo{

	private HotelManagerDao hotelManagerDao; 
	
	public HotelManager() {
		this.hotelManagerDao = RemoteHelper.getInstance().getHotelManagerDao();
//		this.hotelManagerDao = new HotelManagerDao_Stub();
	}

	@Override
	public HotelManagerVO getHotelManagerInfo(String hotelManager_ID) {
		HotelManagerPO po = null;
		try {
			po = hotelManagerDao.getHotelManagerInfo(hotelManager_ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return HotelManagerTransform.hotelManagerTransToVO(po);
	}
	
	public ResultMessage updateHotelManagerInfo(HotelManagerVO vo){
		HotelManagerPO po = HotelManagerTransform.hotelManagerTransToPO(vo);
		
		try {
			if(hotelManagerDao.updateHotelManagerInfo(po)) {
				return ResultMessage.SUCCESS;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return ResultMessage.FAILURE;
	}

	public boolean addHotelManager(HotelManagerPO po) {
		if(po == null) {
			return false;
		}
		
		boolean res = false;
		try {
			res =  this.hotelManagerDao.addHotelManager(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public ResultMessage hotelHasManager(String hotelID) {
		HotelManagerPO po = null;
		try {
			po = this.hotelManagerDao.getHotelManagerInfo(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(po == null) {
			return ResultMessage.FAILURE;
		}
		
		return ResultMessage.SUCCESS;
	}

}
