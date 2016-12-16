package dataDao.stub;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Message.VipType;
import dataDao.user.ClientDao;
import po.ClientPO;

public class ClientDao_Stub implements ClientDao{

	ArrayList<ClientPO> pos = new ArrayList<ClientPO>();
	
	public ClientDao_Stub() {
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String t =format.format(new Date());
		this.pos.add(new ClientPO("wyy", "13338031126","王友运", "3203221111111111111", 
					"head/游客头像.png", VipType.BIRTHDAY_VIP.ordinal(), 2, t));
		
		this.pos.add(new ClientPO("bcy", "18912345678", "卞纯源", "3203222222222222222", null, VipType.BUSINESS_VIP.ordinal(), 2, "南京大学"));
		this.pos.add(new ClientPO("zdy", "1898", "赵德宇", "3203223333222222", null,0, 0, null));
	}

	public boolean addClient(ClientPO po) {
		return true;
	}

	public ClientPO getClientInfo(String clientID) {
		for(int i=0; i<pos.size(); ++i) {
			if(pos.get(i).getUserID().equals(clientID)) {
				return pos.get(i);
			}
		}
		
		return pos.get(0);
	}

	public boolean updateClientInfo(ClientPO clientPO) {
		return true;
	}


}
