package logic.utility;

import po.HotelManagerPO;
import vo.HotelManagerVO;

public class HotelManagerTransform {
	
	private static HotelManagerTransform hotelManagerTransform;
	
	public static HotelManagerTransform getInstance() {
		if(hotelManagerTransform == null) {
			hotelManagerTransform = new HotelManagerTransform();
		}
		return hotelManagerTransform;
	}
	
	//将hotelmanagervo转化为po
	public HotelManagerPO hotelManagerTransToPO(HotelManagerVO vo){
		return new HotelManagerPO(vo.userID, vo.hotelID, vo.phoneNumber, 
				vo.trueName, vo.numberOfIdentityCard);
	}
	
	//将hotelmanagerpo转化为vo
	public HotelManagerVO hotelManagerTransToVO(HotelManagerPO po){
		return new HotelManagerVO(po.getUserID(), po.getHotelID(), po.getPhoneNumber(),
				po.getTrueName(), po.getNumberOfIdentityCard());
	}
}
