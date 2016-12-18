package blDriver;

import client.businesslogicservice.Hotel_blservice;
import client.StateOfLog;
import client.Hotel;

public class Hotel_blservice_Driver {
	public void drive(Hotel_blservice hotel_blservice , StateOfLog stateOfLog , Hotel hotel){
		System.out.println("This is hotel_blservice_Driver");
		hotel_blservice.searchHotel("江宁区","5",300,500);
		hotel_blservice.viewHotel("如家");
		hotel_blservice.hotelHistory(stateOfLog , "wx");
		hotel_blservice.addHotel(hotel);
		hotel_blservice.updateHotel(hotel);
	}
}
