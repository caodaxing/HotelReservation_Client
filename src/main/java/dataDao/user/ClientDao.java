package dataDao.user;

import po.ClientPO;

public interface ClientDao {
	
	public boolean addClient(ClientPO po);
	
	public ClientPO getClientInfo(String clientID);
	
	public boolean updateClientInfo(ClientPO clientPO);
}
