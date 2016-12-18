package Stub;

import java.util.ArrayList;

import Interface.HotelDataService;
import PO.AccountPO;
import PO.HotelPO;
import PO.ResultMessage;
import PO.RoomPO;

public class HotelDataService_Stub implements HotelDataService {
	
	public ResultMessage add(HotelPO po) {
		return ResultMessage.Add_Success;
	}
	
	public ResultMessage modify(HotelPO po) {
		return ResultMessage.Modify_Success;
	}
	
	public HotelPO find(HotelPO po) {
		return new HotelPO("希尔顿酒店", "新街口商圈", 5, 800, "南京新街口","新用户享受8折优惠", null, null);
	}
	
	public ArrayList<HotelPO> Search(String tradingarea , String level , int pricefloor , int priceceiling) {
		ArrayList<HotelPO> hotels=new ArrayList<>();
		hotels.add(new HotelPO("希尔顿酒店", "新街口商圈", 5, 800, "南京新街口","新用户享受8折优惠", null, null));
		hotels.add(new HotelPO("南京新街口汉庭酒店", "新街口商圈", 0, 200, "南京新街口", "新用户8折优优惠", null, null));
		return hotels;
	}
}
