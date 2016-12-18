package blDriver;

import client.businesslogicservice.User_blservice;
import client.vo.HotelManagerVO;

public class User_blserice_Driver {
	public void drive(User_blservice user_blservice , HotelManagerVO hotelManager){
		System.out.println("This is user_blservice_Drivver");
		user_blservice.getUserInfo(1234567);
		user_blservice.deleteUserInfo(1234567,"Name");
		user_blservice.updareUserInfo(1234567,"Name","wx");
		user_blservice.addUserInfo("Age","23");
		user_blservice.updateHotelManager(hotelManager , "123");
		user_blservice.changeVIPLevel(1234567);
	}
	
}