package logic.utility;

import po.WebBusinessPO;
import vo.WebBusinessVO;

public class WebBusinessTransform {
	
	private static WebBusinessTransform webBusinessTransform;
	
	public static WebBusinessTransform getInstance() {
		if(webBusinessTransform == null) {
			webBusinessTransform = new WebBusinessTransform();
		}
		return webBusinessTransform;
	}

	public WebBusinessPO webBusinessTransToPO(WebBusinessVO vo) {
		if(vo == null) {
			return null;
		}
		
		return new WebBusinessPO(vo.userID, vo.trueName,
				vo.phoneNumber, vo.numberOfIdentityCard);
	}
	
	public WebBusinessVO webBusinessTransToVO(WebBusinessPO po) {
		if(po == null) {
			return null;
		}
		
		return new WebBusinessVO(po.getUserID(), po.getTrueName(),
				po.getPhoneNumber(), po.getNumberOfIdentityCard());
	}
}
