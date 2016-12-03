package logic.user;

import Message.ResultMessage;
import dataDao.stub.WebManagerDao_Stub;
import dataDao.user.WebManagerDao;
import logic.utility.HotelManagerTransform;
import logic.utility.WebBusinessTransform;
import logicService.user.WebManagerService;
import po.HotelManagerPO;
import po.HotelPO;
import po.WebBusinessPO;
import vo.HotelManagerVO;
import vo.HotelVO;
import vo.WebBusinessVO;

/**
 * 管理网站管理人员信息的类
 * @author Xue.W
 */
public class WebManager implements WebManagerService {
	
	private String webManagerID;
	private WebManagerDao webManagerDao;
	private HotelManager hotelManager;
	private WebBusiness webBusiness;
	private HotelManagerTransform hotelManagerTrans;
	private WebBusinessTransform webBusinessTrans;
	
	public WebManager(String userID){
		this.webManagerID = userID;
		this.hotelManagerTrans = new HotelManagerTransform();
		this.webBusinessTrans = new WebBusinessTransform();
		
		this.webManagerDao = new WebManagerDao_Stub();
	}
	
	public HotelManagerVO getHotelManagerInfo(String hotelManager_ID) {
		if(hotelManager == null || !hotelManager.getHotelManagerID().equals(hotelManager_ID)) {
			hotelManager = new HotelManager(hotelManager_ID);
		}
		
		return hotelManager.getHotelManagerInfo(hotelManager_ID);
	}
	
	public ResultMessage updateHotelManagerInfo(HotelManagerVO hotelManagerInfo){
		
		if(hotelManager == null || !hotelManager.getHotelManagerID().equals(hotelManagerInfo.userID)) {
			hotelManager = new HotelManager(hotelManagerInfo.userID);
		}
		
		return hotelManager.updateHotelManagerInfo(hotelManagerInfo);
	}
	
	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID){
		if(this.webBusiness == null || !this.webBusiness.getWebBusinessID().equals(webBusiness_ID)){
			this.webBusiness = new WebBusiness(webBusiness_ID);
		}
		
		return this.webBusiness.getWebBusinessInfo(webBusiness_ID);
	}
	
	public ResultMessage updateWebBusinessInfo(WebBusinessVO webBusinessInfo){
		if(this.webBusiness == null || !this.webBusiness.getWebBusinessID().equals(webBusinessInfo.userID)){
			this.webBusiness = new WebBusiness(webBusinessInfo.userID);
		}
		
		return this.webBusiness.updateWebBusinessInfo(webBusinessInfo);
	}
	
	public ResultMessage addHotel(HotelVO hotelVO){
		if(hotelVO != null) {
			HotelPO po = new HotelPO(hotelVO.hoteID, hotelVO.tradingArea, hotelVO.locationOfHotel,hotelVO.levelOfHotel, 
					hotelVO.introduction, hotelVO.facilities, hotelVO.picturesPath, hotelVO.emptyRoomNum, hotelVO.bussiness);	
			if(this.webManagerDao.addHotel(po)) {
				return ResultMessage.SUCCESS;
			}
		}
		return ResultMessage.FAILURE;
	}
	
	public ResultMessage addHotelManager(HotelManagerVO hotelManagerVO){
		
		
		if(hotelManagerVO != null) {
			HotelManagerPO po = this.hotelManagerTrans.hotelManagerTransToPO(hotelManagerVO);
			if(this.webManagerDao.addHotelManager(po)) {
				return ResultMessage.SUCCESS;
			}
		}
		
		return ResultMessage.FAILURE;
	}
	
	public ResultMessage addWebBusiness(WebBusinessVO  webBusinessVO){
		if(webBusinessVO != null){
			WebBusinessPO po = this.webBusinessTrans.webBusinessTransToPO(webBusinessVO);
			if(this.webManagerDao.addWebBusiness(po)) {
				return ResultMessage.SUCCESS;
			}
		}
		return ResultMessage.FAILURE;
	}
	
	public String getWebManagerID() {
		return webManagerID;
	}

	public void setWebManagerID(String webManagerID) {
		this.webManagerID = webManagerID;
	}
	
}
