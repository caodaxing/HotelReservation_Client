package logic.utility;

import po.WebBusinessPO;
import vo.WebBusinessVO;

public class WebBusinessTransform {

	public WebBusinessPO webBusinessTransToPO(WebBusinessVO vo) {
		return new WebBusinessPO(vo.userID, vo.trueName,
				vo.phoneNumber, vo.numberOfIdentityCard);
	}
	
	public WebBusinessVO webBusinessTransToVO(WebBusinessPO po) {
		return new WebBusinessVO(po.getUserID(), po.getTrueName(),
				po.getPhoneNumber(), po.getNumberOfIdentityCard());
	}
}
