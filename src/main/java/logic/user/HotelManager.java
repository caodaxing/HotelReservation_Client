package logic.user;

import Message.ResultMessage;
import dataDao.stub.HotelManagerDao_Stub;
import dataDao.user.HotelManagerDao;
import logic.utility.HotelManagerTransform;
import logicService.user.HotelManagerService;
import po.HotelManagerPO;
import vo.HotelManagerVO;

public class HotelManager implements HotelManagerService{

	private HotelManagerDao hotelManagerDao; 
	private HotelManagerTransform hotelManagerTrans;
	
	public HotelManager() {
		this.hotelManagerTrans = HotelManagerTransform.getInstance();
		
		this.hotelManagerDao = new HotelManagerDao_Stub();
	}

	@Override
	public HotelManagerVO getHotelManagerInfo(String hotelManager_ID) {
		HotelManagerPO po = hotelManagerDao.getHotelManagerInfo(hotelManager_ID);
		
		return this.hotelManagerTrans.hotelManagerTransToVO(po);
	}
	
	public ResultMessage updateHotelManagerInfo(HotelManagerVO vo){
		HotelManagerPO po = this.hotelManagerTrans.hotelManagerTransToPO(vo);
		
		if(hotelManagerDao.updateHotelManagerInfo(po)) {
			return ResultMessage.SUCCESS;
		}
		
		return ResultMessage.FAILURE;
	}

	public boolean addHotelManager(HotelManagerPO po) {
		if(po == null) {
			return false;
		}
		
		return this.hotelManagerDao.addHotelManager(po);
	}

}
