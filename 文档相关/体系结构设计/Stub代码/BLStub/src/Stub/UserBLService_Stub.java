package Stub;

import java.util.ArrayList;

import Interface.UserBLService;
import VO.HotelManagerVO;
import VO.OrderVO;
import VO.ResultMessage;
import VO.RoomVO;
import VO.UserVO;

public class UserBLService_Stub implements UserBLService {
	
	public UserVO getUserInfo(long id) {
		ArrayList<OrderVO> orders = new ArrayList<OrderVO>();
		orders.add(new OrderVO("124523", "20160930", new RoomVO(1, 299, 0, 1123), "20161001", 1, 2, false));
		return new UserVO(id, "mark", "13338021124", 1000, orders);
	} 
	
	public ResultMessage deleteUserInfo(long id, String infoType){
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage updateUserInfo(long id, String infoType,String info){
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage addUserInfo(long id, String infoType, String info){
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage updateHotelManager (HotelManagerVO hotelManager, String hotelId) {
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage changeVIPLevel (int userId){
		return ResultMessage.SUCCESS;
	}
}
