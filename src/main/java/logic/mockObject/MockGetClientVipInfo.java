package logic.mockObject;

import Message.VipType;
import logic.user.GetClientVipInfo;
import vo.VipVO;

public class MockGetClientVipInfo implements GetClientVipInfo{

	@Override
	public VipVO getVipInfo(String userID) {
//		return new VipVO("wyy", VipType.BIRTHDAY_VIP, 2, "1996-12-09");
		return new VipVO("wyy", VipType.BUSINESS_VIP, 2, "南京大学");
	}

	@Override
	public boolean isVIP(String userID) {
		return true;
	}

}
