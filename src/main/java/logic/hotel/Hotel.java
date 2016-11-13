package logic.hotel;

import vo.HotelInfoVO;
import vo.RoomVO;

public class Hotel {
	HotelItem hotelitem;
	public boolean updateRoom (RoomVO room){
		return false;
	}
	public HotelInfoVO getHotelInfo (String hotelName){
		return null;
	}
	public HotelInfoVO getHotelItemInfo (String hotel_id){
		return hotelitem.getHotelItemInfo(hotel_id);
	}
	public boolean updateHotelInfo (HotelInfoVO hotel){
		return false;
	}
	public double calculate(Hotel hotel){
		return 0;
	}
}
