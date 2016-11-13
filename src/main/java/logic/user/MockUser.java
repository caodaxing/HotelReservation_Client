package logic.user;

import vo.UserVO;

public class MockUser extends User {

	public MockUser (UserVO vo){
		userVO = vo;
	}
	
	public int getCredit(){
		return 0;
	}
	
}
