package dataDao.stub;

import dataDao.user.WebBusinessDao;
import po.WebBusinessPO;

public class WebBusinessDao_Stub implements WebBusinessDao {

	@Override
	public WebBusinessPO getWebBusinessInfo(String webBusinessID) {
		if(webBusinessID == "mdzz")
			return new WebBusinessPO("mdzzz", "王雪", "123456", "11");
		else 
			return null;
	}

	@Override
	public boolean updateWebBusinessInfo(WebBusinessPO webBusinessInfo) {
		return true;
	}

	@Override
	public boolean addWebBusiness(WebBusinessPO webBusinessPO) {
		return true;
	}

}
