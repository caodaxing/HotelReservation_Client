package Stub;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import Interface.HotelBLService;
import VO.HotelInfoVO;
import VO.ResultMessage;

public class HotelBLService_Stub implements HotelBLService{
	
	ArrayList<String> hotellist;
	ArrayList<String> historylist;
	ImageIcon image;
	
	public ArrayList<String> searchHotel(String tradingarea , String level , int pricefloor , int priceceiling){
		return hotellist;
	}
	
	public HotelInfoVO viewHotel (String hotelName){
		return new HotelInfoVO("��껾Ƶ�","����ʡ��������ɽ·89��","�۸����У������ܵ�","158����388","kkdki:���Ǻ���",image);
	}
	
	public ArrayList<String> hotelHistory(ResultMessage userstate , String username){
		return historylist;
	}
	
	public HotelInfoVO addHotel(String hotelid){
		return new HotelInfoVO("��ʫ�Ƶ�","����ʡ��������ɽ·9��","�۸����У������ܵ�","138����388","ddedd:���Ǻ���",image);
	}
	
	public HotelInfoVO updateHotel(String hotelid){
		return new HotelInfoVO("��ʫ�Ƶ�","����ʡ��������ɽ·9��","�۸����У������ܵ�","188����368","ddedd:���Ǻ���",image);
	}
}
