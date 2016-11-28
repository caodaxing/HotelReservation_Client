package logic.user;

import Message.ResultMessage;
import vo.WebBusinessVO;

/**
 * 管理网站营销人员信息的类
 * @author Xue.W
 */
public class WebBusiness{
	
	private String webBussinessID;
	
	public WebBusiness(WebBusinessVO wbv){
		this.webBussinessID = wbv.id;
	}
	
	public WebBusiness(){
		
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
	 * @param webBusinessInfo 传入的网站营销人员信息
	 * @return 返回是否修改成功
	 * @author Xue.W
	 */
	public ResultMessage updateWebBusinessInfo(WebBusinessVO webBusinessInfo){
		return ResultMessage.FAILURE;
	}
	
}
