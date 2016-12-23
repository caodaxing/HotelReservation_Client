package logic.utility;

import po.WebBusinessPO;
import vo.WebBusinessVO;

public class WebBusinessTransform {

	public static WebBusinessPO webBusinessTransToPO(WebBusinessVO vo) {
		if(vo == null) {
			return null;
		}
		
		return new WebBusinessPO(vo.userID, vo.trueName,
				vo.phoneNumber, vo.numberOfIdentityCard);
	}
	
	public static WebBusinessVO webBusinessTransToVO(WebBusinessPO po) {
		if(po == null) {
			return null;
		}
		
		return new WebBusinessVO(po.getUserID(), po.getTrueName(),
				po.getPhoneNumber(), po.getNumberOfIdentityCard());
	}
}
