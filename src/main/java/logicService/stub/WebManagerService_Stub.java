package logicService.stub;

import Message.ResultMessage;
import logicService.user.WebManagerService;
import vo.HotelManagerVO;
import vo.HotelVO;
import vo.WebBusinessVO;

public class WebManagerService_Stub implements WebManagerService {

	@Override
	public ResultMessage addHotel(HotelVO hotelVO) {
		return null;
	}

	@Override
	public HotelManagerVO getHotelManagerInfo(String hotel_ID) {
		return null;
	}

	@Override
	public ResultMessage addHotelManager(HotelManagerVO hotelManager) {
		return null;
	}

	@Override
	public ResultMessage updateHotelManagerInfo(HotelManagerVO hotelManagerInfo) {
		return null;
	}

	@Override
	public ResultMessage addWebBusiness(WebBusinessVO webBusinessInfo) {
		return null;
	}

	@Override
	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID) {
		return null;
	}

	@Override
	public ResultMessage updateWebBusinessInfo(WebBusinessVO webBusinessInfo) {
		return null;
	}


}
