package driver;

import java.util.ArrayList;

import Message.ResultMessage;
import logicService.HotelService;
import vo.EvaluationVO;
import vo.HotelSearchVO;
import vo.HotelVO;
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
		HotelVO hivo0 = hotelService.search(hsvo);
		System.out.println(hivo0);
		
		ArrayList<HotelVO> list0 = hotelService.getBookedHotelList("123");
		for(HotelVO h : list0){
			System.out.println(h);
		}
		
		ArrayList<HotelVO> list1 = hotelService.getSortedList();
		for(HotelVO h : list1){
			System.out.println(h);
		}
		
		ArrayList<HotelVO> list2 = hotelService.getInitialHotelList("南京", "栖霞区");
		for(HotelVO h : list2){
			System.out.println(h);
		}
		
		ArrayList<String> strList = hotelService.getTradingArea("南京");
		for(String str : strList){
			System.out.println(str);
		}
		
		HotelVO hivo1 = hotelService.getHotelItemInfo("119");
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
