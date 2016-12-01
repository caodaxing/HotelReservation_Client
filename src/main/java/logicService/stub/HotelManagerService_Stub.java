package logicService.stub;

import logicService.user.HotelManagerService;
import vo.HotelManagerVO;

public class HotelManagerService_Stub implements HotelManagerService {

	private String hotelManagerID;
	
	public HotelManagerService_Stub(String hotelManagerID) {
		super();
		this.hotelManagerID = hotelManagerID;
	}

	public String getHotelManagerID() {
		return hotelManagerID;
	}

	public void setHotelManagerID(String hotelManagerID) {
		this.hotelManagerID = hotelManagerID;
	}

	@Override
	public HotelManagerVO getHotelManagerInfo(String hotel_ID) {
		return null;
	}

}
