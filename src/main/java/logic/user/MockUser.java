package logic.user;

import vo.UserVO;

/**
 * User的mock类
 * @author Xue.W
 */
public class MockUser extends User {

	UserVO userVO;
	
	public MockUser (UserVO vo){
		userVO = vo;
	}
	
	public int getCredit(){
		return userVO.credit;
	}
	
}
