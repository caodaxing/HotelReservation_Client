package logic.user;

import Message.ResultMessage;
import dataDao.WebBusinessDao;
import dataDao.stub.WebBusinessDao_Stub;
import logicService.user.WebBusinessService;
import po.WebBusinessPO;
import vo.WebBusinessVO;

public class WebBusiness implements WebBusinessService{

	private String webBusinessID;
	private WebBusinessPO webBusinessPO;
	private WebBusinessDao webBusinessDao;
	
	public WebBusiness(String webBusinessID) {
		this.webBusinessID = webBusinessID;
		webBusinessDao = new WebBusinessDao_Stub();
		this.initWebBusinessPO();
	}

	private void initWebBusinessPO() {
		this.webBusinessPO = webBusinessDao.getWebBusinessInfo(this.webBusinessID);
	}

	@Override
	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID) {
		if(this.webBusinessDao != null) {
			return new WebBusinessVO(webBusinessPO.getUserID(), webBusinessPO.getTrueName(),
					webBusinessPO.getPhoneNumber(), webBusinessPO.getNumberOfIdentityCard());
		}
		
		WebBusinessPO po = this.webBusinessDao.getWebBusinessInfo(webBusiness_ID);
		this.webBusinessPO = po;
		
		return new WebBusinessVO(po.getUserID(), po.getTrueName(),
				po.getPhoneNumber(), po.getNumberOfIdentityCard());
	}
	
	
	public ResultMessage updateWebBusinessInfo(WebBusinessVO vo){
		WebBusinessPO po = new WebBusinessPO(vo.userID, vo.trueName,
				vo.phoneNumber, vo.numberOfIdentityCard);
		
		if(this.webBusinessDao.updateWebBusinessInfo(po)) {
			this.webBusinessPO = po;
			return ResultMessage.SUCCESS;
		}
		
		return ResultMessage.FAILURE;
	}
	
	public String getWebBusinessID() {
		return webBusinessID;
	}

	public void setWebBusinessID(String webBusinessID) {
		this.webBusinessID = webBusinessID;
	}

	public WebBusinessPO getWebBusinessPO() {
		return webBusinessPO;
	}

	public void setWebBusinessPO(WebBusinessPO webBusinessPO) {
		this.webBusinessPO = webBusinessPO;
	}

}
