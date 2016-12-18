package Stub;

import java.rmi.RemoteException;
import Interface.AccountDataService;
import PO.AccountPO;


public class AccountDataService_Stub implements AccountDataService{

	public boolean add(AccountPO po) throws RemoteException {
		System.out.println("A account Message is added in data!");
		return true;
	}

	public boolean delete(AccountPO po) {
		System.out.println("A account Message has been deleted");
		return true;
	}

	public boolean modify(AccountPO po) {
		System.out.println("The account Message has been modified");
		return true;
	}
}