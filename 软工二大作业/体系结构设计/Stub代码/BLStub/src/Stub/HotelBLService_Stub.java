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
		return new HotelInfoVO("天昊酒店","江苏省无锡市中山路89号","价格适中，服务周到","158——388","kkdki:五星好评",image);
	}
	
	public ArrayList<String> hotelHistory(ResultMessage userstate , String username){
		return historylist;
	}
	
	public HotelInfoVO addHotel(String hotelid){
		return new HotelInfoVO("朗诗酒店","江苏省常州市中山路9号","价格适中，服务周到","138——388","ddedd:五星好评",image);
	}
	
	public HotelInfoVO updateHotel(String hotelid){
		return new HotelInfoVO("朗诗酒店","江苏省常州市中山路9号","价格适中，服务周到","188——368","ddedd:五星好评",image);
	}
}
