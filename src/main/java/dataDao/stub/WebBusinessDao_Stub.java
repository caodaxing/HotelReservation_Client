package dataDao.stub;

import dataDao.WebBusinessDao;
import po.WebBusinessPO;

public class WebBusinessDao_Stub implements WebBusinessDao {

	@Override
	public WebBusinessPO getWebBusinessInfo(String webBusinessID) {
		if(webBusinessID == "mdzz")
			return new WebBusinessPO("mdzz", "王雪", "123456", "11");
		else 
			return null;
	}

	@Override
	public boolean updateWebBusinessInfo(WebBusinessPO webBusinessInfo) {
		return true;
	}

}
