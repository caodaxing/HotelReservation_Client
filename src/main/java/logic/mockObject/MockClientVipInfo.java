package logic.mockObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Message.VipType;
import logic.user.ClientVipInfo;
import vo.VipVO;

public class MockClientVipInfo implements ClientVipInfo{

	@Override
	public VipVO getVipInfo(String userID) {
		if(userID == "wyy") {
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			String t =format.format(new Date());
			return new VipVO("wyy", VipType.BIRTHDAY_VIP, 2, t);
		} 
			
		return new VipVO("bcy", VipType.BUSINESS_VIP, 2, "南京大学");
	}
	
	@Override
	public boolean isVIP(String userID) {
		if(userID == "wyy" || userID == "bcy") {
			return true;
		}
		
		return false;
	}

}
