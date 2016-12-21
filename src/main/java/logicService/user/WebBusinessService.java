package logicService.user;

import vo.WebBusinessVO;

/**
 * 网站营销人员基本信息处理的接口
 * @author Mark.W
 *
 */
public interface WebBusinessService {

	/**
	 * 获取网站管理人员的信息
	 * @param webBusiness_ID
	 * @return
	 */
	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID);
	
}
