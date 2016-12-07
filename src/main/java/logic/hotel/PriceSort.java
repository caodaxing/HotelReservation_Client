package logic.hotel;

import java.util.ArrayList;
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
	 * 讲酒店按价格排序
	 * @param startPrice 最低价格
	 * @param endPrice 最高价格
	 * @return ArrayList<HotelVO> 返回按价格排序好的酒店名称列表
	 * @author all
	 */
	public ArrayList<HotelVO> getSortedList(double startPrice,double endPrice,ArrayList<HotelVO> hotels){
		if (hotels==null || startPrice>=endPrice) {
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
		for (int i = hotelArray.length - 1; i > 0; --i){
			for (int j = 0; j < i; ++j){
				if (hotelArray[j].getLowestPrice()<=hotelArray[j+1].getLowestPrice()) {
					LowestPrice temp = hotelArray[j];
					hotelArray[j] = hotelArray[j+1];
					hotelArray[j+1] = temp;
				}
			}
		}

		for (LowestPrice lowestPrice : hotelArray) {
			sortedHotels.add(lowestPrice.getHotelVO());
		}
		return null;
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
