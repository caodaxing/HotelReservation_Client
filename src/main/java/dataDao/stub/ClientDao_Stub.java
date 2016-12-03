package dataDao.stub;

import dataDao.user.ClientDao;
import po.ClientPO;

public class ClientDao_Stub implements ClientDao{

	public boolean addClient(ClientPO po) {
		return true;
	}

	public ClientPO getClientInfo(String clientID) {
		return new ClientPO("wyy", "13338031126","王友运", "3203221111111111111", 
				"image/wyy.jpg", 2, 1, "南京大学");
	}

	public boolean updateClientInfo(ClientPO clientPO) {
		return true;
	}


}
