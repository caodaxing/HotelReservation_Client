package logic.utility;

import po.HotelManagerPO;
import vo.HotelManagerVO;

public class HotelManagerTransform {
	
	//将hotelmanagervo转化为po
	public static HotelManagerPO hotelManagerTransToPO(HotelManagerVO vo){
		if(vo == null) {
			return null;
		}
		
		return new HotelManagerPO(vo.hotelID, vo.phoneNumber, 
				vo.trueName, vo.numberOfIdentityCard);
	}
	
	//将hotelmanagerpo转化为vo
	public static HotelManagerVO hotelManagerTransToVO(HotelManagerPO po){
		if(po == null) {
			return null;
		}
		
		return new HotelManagerVO(po.getHotelID(), po.getPhoneNumber(),
				po.getTrueName(), po.getIdentityCardID());
	}
}
