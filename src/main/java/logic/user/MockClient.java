package logic.user;

import vo.ClientVO;

/**
 * User的mock类
 * @author Xue.W
 */
public class MockClient extends Client {

	ClientVO clientVO;
	
	public MockClient (ClientVO vo){
		clientVO = vo;
	}
	
	public int getCredit(){
		return clientVO.credit;
	}
	
}
