package dataDao.stub;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Message.VipType;
import dataDao.user.ClientDao;
import po.ClientPO;

public class ClientDao_Stub implements ClientDao{

	public boolean addClient(ClientPO po) {
		return true;
	}

	public ClientPO getClientInfo(String clientID) {
		if(clientID == "wyy") {
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			String t =format.format(new Date());
			return new ClientPO("wyy", "13338031126","王友运", "3203221111111111111", 
					"image/wyy.jpg", VipType.BIRTHDAY_VIP.ordinal(), 2, t);
		} else if(clientID == "bcy"){
			return new ClientPO("bcy", "18912345678", "卞纯源", "3203222222222222222", null, VipType.BUSINESS_VIP.ordinal(), 2, "南京大学");
		}
		
		return new ClientPO("zdy", "1898", "赵德宇", "3203223333222222", null,0, 0, null);
	}

	public boolean updateClientInfo(ClientPO clientPO) {
		return true;
	}


}
