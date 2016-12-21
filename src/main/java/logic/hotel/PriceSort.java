package logic.hotel;

import java.util.ArrayList;

import logic.room.Room;
import logic.room.RoomInfo;
import vo.HotelVO;


/**
 * 按价格排序
 * 默认是价格从低到高
 * @author all
 *
 */
public class PriceSort implements HotelSort{

	//该类获取酒店房间需要用到roominfo最低价格
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
		assert (hotels == null || hotels.size() == 0) :"logic.hotel.PriceSort.getSortedList参数异常";
		
		
		if(hotels.size() == 1) {
			return hotels;
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
		
		assert (hotels == null || startPrice >= endPrice) :"logic.hotel.PriceSort.getSortedList参数异常";
		
		ArrayList<HotelVO> sortedHotels = new ArrayList<HotelVO>();
		// 获取酒店的最低价格的列表
		ArrayList<LowestPrice> lowPriceInitList = new ArrayList<LowestPrice>();
		
		for (int i=0; i<hotels.size(); ++i) {
			HotelVO hotelVO = hotels.get(i);
			lowPriceInitList.add(new LowestPrice(hotelVO));
		}

		// 获取符合排序条件的酒店列表
		ArrayList<LowestPrice> hotelList = new ArrayList<LowestPrice>();
		for (int i=0; i<lowPriceInitList.size(); ++i) {
			LowestPrice lowestPrice = lowPriceInitList.get(i);
			if (lowestPrice.getLowestPrice() >= startPrice && lowestPrice.getLowestPrice() <= endPrice) {
				hotelList.add(lowestPrice);
			}
		}
		

		for (int i=0; i<hotelList.size(); ++i) {
			LowestPrice lowestPrice = hotelList.get(i);
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
			this.LowestPrice = roomInfo.getHotelLowestPrice(hotelVO.hoteID);
		}

		public double getLowestPrice() {
			return LowestPrice;
		}

		public HotelVO getHotelVO() {
			return hotelVO;
		}

	}

}
