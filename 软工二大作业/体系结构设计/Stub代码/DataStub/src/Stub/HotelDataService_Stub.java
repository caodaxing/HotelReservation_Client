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
		return new HotelPO("ϣ���پƵ�", "�½ֿ���Ȧ", 5, 800, "�Ͼ��½ֿ�","���û�����8���Ż�", null, null);
	}
	
	public ArrayList<HotelPO> Search(String tradingarea , String level , int pricefloor , int priceceiling) {
		ArrayList<HotelPO> hotels=new ArrayList<>();
		hotels.add(new HotelPO("ϣ���پƵ�", "�½ֿ���Ȧ", 5, 800, "�Ͼ��½ֿ�","���û�����8���Ż�", null, null));
		hotels.add(new HotelPO("�Ͼ��½ֿں�ͥ�Ƶ�", "�½ֿ���Ȧ", 0, 200, "�Ͼ��½ֿ�", "���û�8�����Ż�", null, null));
		return hotels;
	}
}
