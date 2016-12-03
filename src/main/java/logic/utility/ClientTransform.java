package logic.utility;

import logic.credit.CreditInfo;
import logic.credit.MockCreditInfo;
import po.ClientPO;
import vo.ClientVO;

public class ClientTransform {

	private CreditInfo creditInfo;

	public ClientTransform() {
		this.creditInfo = new MockCreditInfo();
	}
	
	public ClientVO clientTransToVO(ClientPO clientPO) {
		if(clientPO == null) {
			return null;
		}
		
		return new ClientVO(clientPO.getUserID(),clientPO.getPhoneNumber(), 
				clientPO.getTrueName(), clientPO.getIdentityID(), 
				creditInfo.getCredit(clientPO.getUserID()), clientPO.getHeadImagePath());
	}
	
}
