package logic.user;

import Message.ResultMessage;
import dataDao.stub.WebBusinessDao_Stub;
import dataDao.user.WebBusinessDao;
import logic.utility.WebBusinessTransform;
import logicService.user.WebBusinessService;
import po.WebBusinessPO;
import vo.WebBusinessVO;

public class WebBusiness implements WebBusinessService{

	private String webBusinessID;
	private WebBusinessPO webBusinessPO;
	private WebBusinessDao webBusinessDao;
	private WebBusinessTransform webBusinessTrans;
	
	public WebBusiness(String webBusinessID) {
		this.webBusinessID = webBusinessID;
		this.webBusinessTrans = WebBusinessTransform.getInstance();
		
		webBusinessDao = new WebBusinessDao_Stub();
		this.initWebBusinessPO();
	}

	private void initWebBusinessPO() {
		this.webBusinessPO = webBusinessDao.getWebBusinessInfo(this.webBusinessID);
	}

	@Override
	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID) {
		if(this.webBusinessDao != null) {
			return this.webBusinessTrans.webBusinessTransToVO(this.webBusinessPO);
		}
		
		WebBusinessPO po = this.webBusinessDao.getWebBusinessInfo(webBusiness_ID);
		this.webBusinessPO = po;
		
		return this.webBusinessTrans.webBusinessTransToVO(po);
	}
	
	
	public ResultMessage updateWebBusinessInfo(WebBusinessVO vo){
		WebBusinessPO po = this.webBusinessTrans.webBusinessTransToPO(vo);
		
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

	public boolean addWebBusiness(WebBusinessPO po) {
		return this.webBusinessDao.addWebBusiness(po);
	}

}
