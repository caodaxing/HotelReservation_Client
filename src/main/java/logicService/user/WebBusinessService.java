package logicService.user;

import vo.WebBusinessVO;

/**
 * 网站营销人员基本信息处理的接口
 * @author Mark.W
 *
 */
public interface WebBusinessService {

	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID);
	
	public boolean webBusinessIDExists(String userID);
	
}
