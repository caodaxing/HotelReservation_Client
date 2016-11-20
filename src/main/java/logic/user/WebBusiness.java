package logic.user;

import Message.ResultMessage;
import vo.WebBusinessVO;

/**
 * 管理网站营销人员信息的类
 * @author Xue.W
 */
public class WebBusiness {
	
	WebBusinessVO wbv ;
	
	public WebBusiness(WebBusinessVO wbv){
		this.wbv = wbv ;
	}
	
	public WebBusiness(){
		
	}
	
	/**
	 * 新增网站营销人员
	 * @param webBusineInfo 传入的网站营销人员信息
	 * @return 返回是否新增成功
	 * @author Xue.W
	 */
	public ResultMessage addWebBusiness (WebBusinessVO webBusinessInfo){
		return ResultMessage.FAILURE;
	}
	
	/**
	 * 获得网站营销人员信息
	 * @param webBusin_ID 传入的网站营销人员ID
	 * @return 返回网站营销人员信息
	 * @author Xue.W
	 */
	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID){
		return null;
	}
	
	/**
	 * 获得用户信息
	 * @param webBusiness_ID 传入的网站营销人员ID信息
	 * @param webBusinessInfo 传入的网站营销人员信息
	 * @return 返回是否修改成功
	 * @author Xue.W
	 */
	public ResultMessage updateWebBusinessInfo(WebBusinessVO webBusinessInfo , String webBusiness_ID){
		return ResultMessage.FAILURE;
	}
	
}
