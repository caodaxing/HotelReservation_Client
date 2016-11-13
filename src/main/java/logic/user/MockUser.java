package logic.user;

import vo.UserVO;

public class MockUser extends User {

	UserVO userVO;
	
	public MockUser (UserVO vo){
		userVO = vo;
	}
	
	public int getCredit(){
		return userVO.credit;
	}
	
}
