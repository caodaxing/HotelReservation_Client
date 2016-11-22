package driver;

import java.util.ArrayList;

import Message.ResultMessage;
import logicService.UserService;
import vo.HotelInfoVO;
import vo.HotelManagerVO;
import vo.ClientVO;
import vo.VIPInfoVO;
import vo.WebBusinessVO;

/**
 * UserBLService 的 Driver
 * @author XueWang
 */
public class UserDriver {

	public void drive(UserService userService){
		
		System.out.println("This is userServiceDriver");
		
		ClientVO uvo =  userService.getUserInfo("123");
		System.out.println(uvo);
	
		ClientVO user = new ClientVO("128","习近平", "13894858311" , 8888 , null);
		ResultMessage result0 = userService.updateUserInfo(user , "128");
		if(result0 == ResultMessage.SUCCESS){
			System.out.println("Updae User success");
		}else if(result0 == ResultMessage.FAILURE){
			System.out.println("Update User fail");
		}else{
			System.out.println("Error");
		}
		
		VIPInfoVO vipVO = new VIPInfoVO("总书记" , "8");
		ResultMessage result1 = userService.setVIP(vipVO, "126");
		if(result1 == ResultMessage.SUCCESS){
			System.out.println("SetVIP success");
		}else if(result1 == ResultMessage.FAILURE){
			System.out.println("SetVIP fail");
		}else{
			System.out.println("Error");
		}
		
		VIPInfoVO vipVO1 = userService.getVIPInfo("126");
		System.out.println(vipVO1);
		
		ArrayList<HotelInfoVO> list = userService.getHistoryHotelInfo("123");
		for(HotelInfoVO h : list){
			System.out.println(h);
		}
		
		HotelManagerVO hotelManager = new HotelManagerVO( "119" , "王浩然" , "哈哈哈");
		ResultMessage result2 = userService.addHotelManagerInfo(hotelManager, "119");
		if(result2 == ResultMessage.SUCCESS){
			System.out.println("add HotelManager success");
		}else if(result2 == ResultMessage.FAILURE){
			System.out.println("add HotelManager fail");
		}else{
			System.out.println("Error");
		}
		
		HotelManagerVO h1 = userService.getHotelManagerInfo("119");
		System.out.println(h1);
		
		ResultMessage result3 = userService.updateHotelManagerInfo(hotelManager, "119");
		if(result3 == ResultMessage.SUCCESS){
			System.out.println("Update hotelManager success");
		}else if(result3 == ResultMessage.FAILURE){
			System.out.println("Update hotelManager fail");
		}else{
			System.out.println("Error");
		}
		
		WebBusinessVO webBusiness = new WebBusinessVO("888", "张田田" , "wowow");
		ResultMessage result4 = userService.addWebBusiness(webBusiness);
		if(result4 == ResultMessage.SUCCESS){
			System.out.println("Add webBusiness success");
		}else if(result4 == ResultMessage.FAILURE){
			System.out.println("Add webBusiness fail");
		}else{
			System.out.println("Error");
		}
		
		WebBusinessVO w1 = userService.getWebBusinessInfo("222");
		System.out.println(w1);
		
		ResultMessage result5 = userService.updateWebBusinessInfo(webBusiness, "333");
		if(result5 == ResultMessage.SUCCESS){
			System.out.println("Update webBusiness success");
		}else if(result5 == ResultMessage.FAILURE){
			System.out.println("Update webBusiness fail");
		}else{
			System.out.println("Error");
		}
		
	}

}
