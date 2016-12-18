package Stub;

import Interface.PromotionDAtaService;
import PO.AccountPO;

public class PromotionDAtaService_Stub implements PromotionDAtaService {

	public  AccountPO returnVipLevel(String username,String password) {
		return new AccountPO("user", "Bcy", "123", true, "2000.0.0", null, "bcy", null, null, "123445");
	}

	public double returnVipDiscount(String username,String tradingarea,String date,int number) {
		return 0.8;
	}
}
