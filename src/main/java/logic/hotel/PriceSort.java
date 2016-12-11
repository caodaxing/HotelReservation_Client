package logic.hotel;

import java.util.ArrayList;

import Message.HotelSearchCondition;
import logic.room.RoomInfo;
import logic.room.Room;
import vo.HotelVO;
import vo.RoomVO;

/**
 * 按价格排序
 * 
 * @author all
 *
 */
public class PriceSort implements HotelSort{

	private  UpOrDownSort sort;

	public PriceSort() {
		this.sort = new Up();
	}
	
	public PriceSort(UpOrDownSort sort) {
		this.sort = sort;
	}

	
	/**
	 * 根据酒店最低价格进行排列
	 * @param hotels
	 * @return
	 */
	public ArrayList<HotelVO> getSortedList(ArrayList<HotelVO> hotels) {
		if (hotels == null) {
System.out.println("logic.hotel.PriceSort.getSortedList参数异常");
			return null;
		}
		
		ArrayList<HotelVO> sortedHotels = new ArrayList<>();
		// 获取酒店的最低价格的列表
		LowestPrice[] lowPriceList = new LowestPrice[hotels.size()];
		for (int i = 0; i < hotels.size(); i++) {
			lowPriceList[i] = new LowestPrice(hotels.get(i));
		}
		// 对符合排序条件的酒店进行排序
		for (int i = lowPriceList.length - 1; i > 0; --i) {
			for (int j = 0; j < i; ++j) {
				if (sort.compare(lowPriceList[j].getLowestPrice(), lowPriceList[j + 1].getLowestPrice())) {
					LowestPrice temp = lowPriceList[j];
					lowPriceList[j] = lowPriceList[j + 1];
					lowPriceList[j + 1] = temp;
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
	 * 
	 * @param startPrice 最低价格
	 * @param endPrice 最高价格
	 * @return ArrayList<HotelVO> 返回按价格排序好的酒店名称列表
	 * @author all
	 */
	public ArrayList<HotelVO> getSpecificSectionHotelList(double startPrice, double endPrice, ArrayList<HotelVO> hotels) {
		
		if (hotels == null || startPrice >= endPrice){
System.out.println("logic.hotel.PriceSort.getSortedList参数异常");
			return null;
		}
		ArrayList<HotelVO> sortedHotels = new ArrayList<>();
		// 获取酒店的最低价格的列表
		ArrayList<LowestPrice> lowPriceList = new ArrayList<>();
		
		for (HotelVO hotelVO : hotels) {
			lowPriceList.add(new LowestPrice(hotelVO));
		}

		// 获取符合排序条件的酒店列表
		ArrayList<LowestPrice> hotelList = new ArrayList<>();
		for (LowestPrice lowestPrice : hotelList) {
			if (lowestPrice.getLowestPrice() >= startPrice || lowestPrice.getLowestPrice() <= endPrice) {
				hotelList.add(lowestPrice);
			}
		}

		for (LowestPrice lowestPrice : hotelList) {
			sortedHotels.add(lowestPrice.getHotelVO());
		}
		
		return this.getSortedList(sortedHotels);
	}

	// 获取酒店最低价的类
	private class LowestPrice {
		private double LowestPrice;
		private HotelVO hotelVO;

		public LowestPrice(HotelVO hotelVO) {
			this.hotelVO = hotelVO;
			RoomInfo roomInfo = new Room();
			ArrayList<RoomVO> roomList = roomInfo.getRoomList(hotelVO.hoteID);
			LowestPrice = roomList.get(0).price;
			for (RoomVO roomVO : roomList) {
				if (roomVO.price < LowestPrice) {
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
