package data.stub;

import dataDao.WebBusinessDao;
import po.WebBusinessPO;

public class WebBusinessDao_Stub implements WebBusinessDao {

	@Override
	public WebBusinessPO getWebBusinessInfo(String webBusiness_ID) {
		return null;
	}

	@Override
	public boolean updateWebBusinessInfo(WebBusinessPO webBusinessInfo) {
		return false;
	}

}
