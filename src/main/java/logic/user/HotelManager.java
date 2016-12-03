package logic.user;

import Message.ResultMessage;
import dataDao.stub.HotelManagerDao_Stub;
import dataDao.user.HotelManagerDao;
import logic.utility.HotelManagerTransform;
import logicService.user.HotelManagerService;
import po.HotelManagerPO;
import vo.HotelManagerVO;

public class HotelManager implements HotelManagerService{

	private String hotelManagerID;
	private HotelManagerPO hotelManagerPO;
	private HotelManagerDao hotelManagerDao; 
	private HotelManagerTransform hotelManagerTrans;
	
	public HotelManager(String hotelManagerID) {
		this.hotelManagerID = hotelManagerID;
		this.hotelManagerTrans = new HotelManagerTransform();
		
		this.hotelManagerDao = new HotelManagerDao_Stub();
		this.initHotelManagerPO();
	}

	private void initHotelManagerPO() {
		this.hotelManagerPO = this.hotelManagerDao.getHotelManagerInfo(hotelManagerID);
	}

	@Override
	public HotelManagerVO getHotelManagerInfo(String hotelManager_ID) {
		if(hotelManagerPO != null) {
			return this.hotelManagerTrans.hotelManagerTransToVO(hotelManagerPO);
		}
		
		HotelManagerPO po = hotelManagerDao.getHotelManagerInfo(hotelManager_ID);
		this.hotelManagerPO = po;
		return this.hotelManagerTrans.hotelManagerTransToVO(po);
	}
	
	public ResultMessage updateHotelManagerInfo(HotelManagerVO vo){
		HotelManagerPO po = this.hotelManagerTrans.hotelManagerTransToPO(vo);
		if(hotelManagerDao.updateHotelManagerInfo(po)) {
			this.hotelManagerPO = po;			//更新成员变量中的po
			return ResultMessage.SUCCESS;
		}
		
		return ResultMessage.FAILURE;
	}
	
	public String getHotelManagerID() {
		return hotelManagerID;
	}

	public void setHotelManagerID(String hotelManagerID) {
		this.hotelManagerID = hotelManagerID;
	}
	
	public HotelManagerPO getHotelManagerPO() {
		return hotelManagerPO;
	}

	public void setHotelManagerPO(HotelManagerPO hotelManagerPO) {
		this.hotelManagerPO = hotelManagerPO;
	}

}
