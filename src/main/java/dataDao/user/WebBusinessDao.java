package dataDao.user;

import po.WebBusinessPO;

public interface WebBusinessDao {

	public WebBusinessPO getWebBusinessInfo(String webBusiness_ID);
	
	public boolean updateWebBusinessInfo(WebBusinessPO webBusinessInfo);
	
}