package logic.mockObject;

import logic.user.GetClientVipInfo;
import vo.VipVO;

public class MockGetClientVipInfo implements GetClientVipInfo{

	@Override
	public VipVO getVipInfo(String userID) {
		return null;
	}

	@Override
	public boolean isVIP(String userID) {
		return false;
	}

}
