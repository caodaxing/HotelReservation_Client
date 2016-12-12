package logic.user;

import Message.ResultMessage;
import dataDao.stub.WebBusinessDao_Stub;
import dataDao.user.WebBusinessDao;
import logic.utility.WebBusinessTransform;
import logicService.user.WebBusinessService;
import po.WebBusinessPO;
import vo.WebBusinessVO;

public class WebBusiness implements WebBusinessService{

	private WebBusinessDao webBusinessDao;
	private WebBusinessTransform webBusinessTrans;
	
	public WebBusiness() {
		this.webBusinessTrans = WebBusinessTransform.getInstance();
		
		webBusinessDao = new WebBusinessDao_Stub();
	}

	@Override
	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID) {
		
		WebBusinessPO po = this.webBusinessDao.getWebBusinessInfo(webBusiness_ID);
		
		return this.webBusinessTrans.webBusinessTransToVO(po);
	}
	
	
	public ResultMessage updateWebBusinessInfo(WebBusinessVO vo){
		WebBusinessPO po = this.webBusinessTrans.webBusinessTransToPO(vo);
		
		if(this.webBusinessDao.updateWebBusinessInfo(po)) {
			return ResultMessage.SUCCESS;
		}
		
		return ResultMessage.FAILURE;
	}
	
	
	public boolean addWebBusiness(WebBusinessPO po) {
		return this.webBusinessDao.addWebBusiness(po);
	}

}
