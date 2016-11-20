package driver;

import java.util.ArrayList;

import Message.ResultMessage;
import logicService.HotelService;
import vo.EvaluationVO;
import vo.HotelInfoVO;
import vo.HotelSearchVO;
import vo.RoomVO;

/**
 * HotelBLService 的 Driver
 * @author XueWang
 */
public class HotelDriver {
	
	public void drive(HotelService hotelService){
		
		System.out.println("This is HotelServiceDriver");
		
		RoomVO rvo = new RoomVO(1,2,3,"110");
		
		HotelSearchVO hsvo = new HotelSearchVO("仙林大道163号","栖霞区","南京大学",rvo,"五星","163-500");
		HotelInfoVO hivo0 = hotelService.search(hsvo);
		System.out.println(hivo0);
		
		ArrayList<HotelInfoVO> list0 = hotelService.getBookedHotelList("123");
		for(HotelInfoVO h : list0){
			System.out.println(h);
		}
		
		ArrayList<HotelInfoVO> list1 = hotelService.getSortedList();
		for(HotelInfoVO h : list1){
			System.out.println(h);
		}
		
		ArrayList<HotelInfoVO> list2 = hotelService.getInitialHotelList("南京", "栖霞区");
		for(HotelInfoVO h : list2){
			System.out.println(h);
		}
		
		ArrayList<String> strList = hotelService.getTradingArea("南京");
		for(String str : strList){
			System.out.println(str);
		}
		
		HotelInfoVO hivo1 = hotelService.getHotelItemInfo("119");
		System.out.println(hivo1);
		
		ArrayList<EvaluationVO> evaList = hotelService.getHotelInfo("119");
		for(EvaluationVO e: evaList){
			System.out.println(e);
		}
		
		ResultMessage result = hotelService.updateRoom(rvo);
		if(result == ResultMessage.SUCCESS){
			System.out.println("UpdateRoom success");
		}else if(result == ResultMessage.FAILURE){
			System.out.println("UpdateRoom fail");
		}else{
			System.out.println("Error");
		}
		
	}
	
}
