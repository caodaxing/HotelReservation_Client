package logic.user;

import java.rmi.RemoteException;

import Message.ResultMessage;
import dataDao.user.WebBusinessDao;
import logic.utility.WebBusinessTransform;
import logicService.user.WebBusinessService;
import main.rmi.RemoteHelper;
import po.WebBusinessPO;
import vo.WebBusinessVO;

public class WebBusiness implements WebBusinessService{

	private WebBusinessDao webBusinessDao;
	
	public WebBusiness() {
		webBusinessDao = RemoteHelper.getInstance().getWebBusinessDao();
//		webBusinessDao = new WebBusinessDao_Stub();
	}

	@Override
	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID) {
		
		WebBusinessPO po = null;
		try {
			po = this.webBusinessDao.getWebBusinessInfo(webBusiness_ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return WebBusinessTransform.webBusinessTransToVO(po);
	}
	
	
	public ResultMessage updateWebBusinessInfo(WebBusinessVO vo){
		WebBusinessPO po = WebBusinessTransform.webBusinessTransToPO(vo);
		
		try {
			if(this.webBusinessDao.updateWebBusinessInfo(po)) {
				return ResultMessage.SUCCESS;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return ResultMessage.FAILURE;
	}
	
	
	public boolean addWebBusiness(WebBusinessPO po) {
		
		boolean res = false;
		try {
			res =  this.webBusinessDao.addWebBusiness(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
