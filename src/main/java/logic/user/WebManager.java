package logic.user;

import Message.ResultMessage;
import logic.utility.HotelManagerTransform;
import logic.utility.WebBusinessTransform;
import logicService.user.WebManagerService;
import po.HotelManagerPO;
import po.WebBusinessPO;
import vo.HotelManagerVO;
import vo.WebBusinessVO;

/**
 * 管理网站管理人员信息的类
 * @author Xue.W
 */
public class WebManager implements WebManagerService {
	
	private HotelManager hotelManager;
	private WebBusiness webBusiness;
	private HotelManagerTransform hotelManagerTrans;
	private WebBusinessTransform webBusinessTrans;
	
	public WebManager(){
		
		this.hotelManager = new HotelManager();
		this.webBusiness = new WebBusiness();
		
		this.hotelManagerTrans = HotelManagerTransform.getInstance();
		this.webBusinessTrans = WebBusinessTransform.getInstance();
	}
	
	public HotelManagerVO getHotelManagerInfo(String hotelManager_ID) {
		
		return hotelManager.getHotelManagerInfo(hotelManager_ID);
	}
	
	public ResultMessage updateHotelManagerInfo(HotelManagerVO hotelManagerInfo){
		
		return hotelManager.updateHotelManagerInfo(hotelManagerInfo);
	}
	
	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID){
		
		return this.webBusiness.getWebBusinessInfo(webBusiness_ID);
	}
	
	public ResultMessage updateWebBusinessInfo(WebBusinessVO webBusinessInfo){
		
		return this.webBusiness.updateWebBusinessInfo(webBusinessInfo);
	}
	
	public ResultMessage addHotelManager(HotelManagerVO hotelManagerVO){
		
		
		if(hotelManagerVO != null) {
			HotelManagerPO po = this.hotelManagerTrans.hotelManagerTransToPO(hotelManagerVO);
			if(this.hotelManager.addHotelManager(po)) {
				return ResultMessage.SUCCESS;
			}
		}
		
		return ResultMessage.FAILURE;
	}
	
	public ResultMessage addWebBusiness(WebBusinessVO  webBusinessVO){
		if(webBusinessVO != null){
			WebBusinessPO po = this.webBusinessTrans.webBusinessTransToPO(webBusinessVO);
			if(this.webBusiness.addWebBusiness(po)) {
				return ResultMessage.SUCCESS;
			}
		}
		return ResultMessage.FAILURE;
	}

}
