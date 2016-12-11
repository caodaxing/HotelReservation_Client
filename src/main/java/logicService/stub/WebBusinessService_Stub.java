package logicService.stub;

import logicService.user.WebBusinessService;
import vo.WebBusinessVO;

public class WebBusinessService_Stub implements WebBusinessService{

	private String webBusinessID = "000000";
	
	public WebBusinessService_Stub() {
		super();
	}

	public String getWebBusinessID() {
		return webBusinessID;
	}

	public void setWebBusinessID(String webBusinessID) {
		this.webBusinessID = webBusinessID;
	}

	@Override
	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID) {
		return null;
	}

}
