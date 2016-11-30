package logic.user;

import Message.ResultMessage;
import dataDao.HotelManagerDao;
import dataDao.stub.HotelManagerDao_Stub;
import logicService.HotelManagerService;
import po.HotelManagerPO;
import vo.HotelManagerVO;

public class HotelManager implements HotelManagerService{

	private String hotelManagerID;
	private HotelManagerPO hotelManagerPO;
	private HotelManagerDao hotelManagerDao; 
	
	public HotelManager(String hotelManagerID) {
		this.hotelManagerID = hotelManagerID;
		this.hotelManagerDao = new HotelManagerDao_Stub();
		this.initHotelManagerPO();
		
	}

	private void initHotelManagerPO() {
		this.hotelManagerPO = this.hotelManagerDao.getHotelManagerInfo(hotelManagerID);
	}

	@Override
	public HotelManagerVO getHotelManagerInfo(String hotelManager_ID) {
		if(hotelManagerPO != null) {
			return new HotelManagerVO(hotelManagerPO.getUserID(), hotelManagerPO.getHotelID(), hotelManagerPO.getPhoneNumber(),
					hotelManagerPO.getTrueName(), hotelManagerPO.getNumberOfIdentityCard());
		}
		
		HotelManagerPO po = hotelManagerDao.getHotelManagerInfo(hotelManager_ID);
		this.hotelManagerPO = po;
		return new HotelManagerVO(po.getUserID(), po.getHotelID(), po.getPhoneNumber(),
				po.getTrueName(), po.getNumberOfIdentityCard());
	}
	
	public ResultMessage updateHotelManagerInfo(HotelManagerVO vo){
		HotelManagerPO po = new HotelManagerPO(vo.userID, vo.hotelID, vo.phoneNumber, 
				vo.trueName, vo.numberOfIdentityCard);
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
