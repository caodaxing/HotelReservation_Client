package logic.hotel;

import java.util.ArrayList;

import Message.HotelSearchCondition;
import logic.room.GetRoomInfo;
import logic.room.Room;
import vo.HotelVO;
import vo.RoomVO;

/**
 * 按价格排序
 * @author all
 *
 */
public class PriceSort {
	
	/**
	 * 根据酒店最低价格进行排列
	 * @param hotels
	 * @return
	 */
	public ArrayList<HotelVO> getSortedList(HotelSearchCondition condition ,ArrayList<HotelVO> hotels){
		if (hotels==null || condition!=HotelSearchCondition.PRICE_UP || condition!=HotelSearchCondition.PRICE_DOWN) {
			System.out.println("logic.hotel.PriceSort.getSortedList参数异常");
			return null;
		}
		ArrayList<HotelVO> sortedHotels = new ArrayList<>();
		//获取酒店的最低价格的列表
		LowestPrice[] lowPriceList = new LowestPrice[hotels.size()];
		for (int i = 0 ; i <hotels.size() ; i++) {
			lowPriceList[i]=new LowestPrice(hotels.get(i));
		}
		//对符合排序条件的酒店进行排序
		if (condition==HotelSearchCondition.PRICE_UP) {							//升序
			for (int i = lowPriceList.length - 1; i > 0; --i){
				for (int j = 0; j < i; ++j){
					if (lowPriceList[j].getLowestPrice()<=lowPriceList[j+1].getLowestPrice()) {
						LowestPrice temp = lowPriceList[j];
						lowPriceList[j] = lowPriceList[j+1];
						lowPriceList[j+1] = temp;
					}
				}
			}
		}else {																	//降序
			for (int i = lowPriceList.length - 1; i > 0; --i){
				for (int j = 0; j < i; ++j){
					if (lowPriceList[j].getLowestPrice()>=lowPriceList[j+1].getLowestPrice()) {
						LowestPrice temp = lowPriceList[j];
						lowPriceList[j] = lowPriceList[j+1];
						lowPriceList[j+1] = temp;
					}
				}
			}
			
		}
		
		for (LowestPrice lowestPrice : lowPriceList) {
			sortedHotels.add(lowestPrice.getHotelVO());
		}
		
		return sortedHotels;
	}
	/**
	 * 讲酒店按价格区间排序
	 * @param startPrice 最低价格
	 * @param endPrice 最高价格
	 * @return ArrayList<HotelVO> 返回按价格排序好的酒店名称列表
	 * @author all
	 */
	public ArrayList<HotelVO> getSortedList(double startPrice,double endPrice,HotelSearchCondition condition ,ArrayList<HotelVO> hotels){
		if (hotels==null || startPrice>=endPrice || condition!=HotelSearchCondition.PRICE_UP || condition!=HotelSearchCondition.PRICE_DOWN) {
			System.out.println("logic.hotel.PriceSort.getSortedList参数异常");
			return null;
		}
		ArrayList<HotelVO> sortedHotels = new ArrayList<>();
		//获取酒店的最低价格的列表
		ArrayList<LowestPrice> lowPriceList = new ArrayList<>();
		for (HotelVO hotelVO : hotels) {
			lowPriceList.add(new LowestPrice(hotelVO));
		}

		//获取符合排序条件的酒店列表
		ArrayList<LowestPrice> hotelList = new ArrayList<>();
		for (LowestPrice lowestPrice : hotelList) {
			if (lowestPrice.getLowestPrice()>=startPrice || lowestPrice.getLowestPrice()<=endPrice) {
				hotelList.add(lowestPrice);
			}
		}
		
		//对符合排序条件的酒店进行排序
		LowestPrice[] hotelArray = new LowestPrice[hotelList.size()];
		for (int i = 0; i < hotelList.size(); i++) {
			hotelArray[i] = hotelList.get(i);
		}
		if (condition==HotelSearchCondition.PRICE_UP) {						//升序
			for (int i = hotelArray.length - 1; i > 0; --i){
				for (int j = 0; j < i; ++j){
					if (hotelArray[j].getLowestPrice()<=hotelArray[j+1].getLowestPrice()) {
						LowestPrice temp = hotelArray[j];
						hotelArray[j] = hotelArray[j+1];
						hotelArray[j+1] = temp;
					}
				}
			}
		}else {																//降序
			for (int i = hotelArray.length - 1; i > 0; --i){
				for (int j = 0; j < i; ++j){
					if (hotelArray[j].getLowestPrice()>=hotelArray[j+1].getLowestPrice()) {
						LowestPrice temp = hotelArray[j];
						hotelArray[j] = hotelArray[j+1];
						hotelArray[j+1] = temp;
					}
				}
			}
		}
		
		for (LowestPrice lowestPrice : hotelArray) {
			sortedHotels.add(lowestPrice.getHotelVO());
		}
		return sortedHotels;
	}
	
	//获取酒店最低价的类
	private class LowestPrice{
		private double LowestPrice;
		private HotelVO hotelVO;
		
		public LowestPrice(HotelVO hotelVO) {
			this.hotelVO = hotelVO;
			GetRoomInfo roomInfo = new Room();
			ArrayList<RoomVO> roomList = roomInfo.getRoomList(hotelVO.hoteID);
			LowestPrice = roomList.get(0).price;
			for(RoomVO roomVO : roomList){
				if (roomVO.price<LowestPrice) {
					LowestPrice = roomVO.price;
				}
			}
		}

		public double getLowestPrice() {
			return LowestPrice;
		}

		public HotelVO getHotelVO() {
			return hotelVO;
		}

	}
	
}
