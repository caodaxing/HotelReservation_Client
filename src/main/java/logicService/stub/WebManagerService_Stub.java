package logicService.stub;

import Message.ResultMessage;
import logicService.user.WebManagerService;
import vo.HotelManagerVO;
import vo.HotelVO;
import vo.WebBusinessVO;

public class WebManagerService_Stub implements WebManagerService {

	private String webManagerID;
	
	public WebManagerService_Stub(String webManagerID) {
		super();
		this.webManagerID = webManagerID;
	}

	public String getWebManagerID() {
		return webManagerID;
	}

	public void setWebManagerID(String webManagerID) {
		this.webManagerID = webManagerID;
	}

	@Override
	public HotelManagerVO getHotelManagerInfo(String hotel_ID) {
		return new HotelManagerVO("123","456","789","1112");
	}

	@Override
	public ResultMessage addHotelManager(HotelManagerVO hotelManager) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updateHotelManagerInfo(HotelManagerVO hotelManagerInfo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage addWebBusiness(WebBusinessVO webBusinessInfo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID) {
		return null;
	}

	@Override
	public ResultMessage updateWebBusinessInfo(WebBusinessVO webBusinessInfo) {
		return ResultMessage.SUCCESS;
	}


}
