package logicService.stub;

import logicService.user.WebBusinessService;
import vo.WebBusinessVO;

public class WebBusinessService_Stub implements WebBusinessService{

	private String webBusinessID;
	
	public WebBusinessService_Stub(String webBusinessID) {
		super();
		this.webBusinessID = webBusinessID;
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
