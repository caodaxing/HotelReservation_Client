package logic.hotel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Message.HotelSearchCondition;
import dataDao.hotel.HotelDao;
import dataDao.stub.HotelDao_Stub;
import factories.HotelSortFactory;
import logic.order.Order;
import logic.order.OrderHotelInfo;
import logic.room.Room;
import logic.room.RoomInfo;
import logic.utility.HotelTransform;
import logic.utility.Time;
import logicService.hotel.SearchHotelService;
import po.HotelPO;
import vo.HotelSearchVO;
import vo.HotelVO;

/**
 * 搜索酒店
 * @author all
 *
 */
public class SearchHotel implements SearchHotelService {

	private HotelDao hotelDao;
	private OrderHotelInfo orderHotelInfo;
	private HotelSort hotelSort;

	public SearchHotel() {
		hotelDao = new HotelDao_Stub();
		
		orderHotelInfo = new Order();
	}

	public ArrayList<String> getTradingArea(String city) {
		ArrayList<String> res = null;
		try {
			res =  hotelDao.getTradingAreas(city);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	/**
	 * 获取指定地址指定商圈符合条件的酒店列表
	 * @param city 传入酒店所属城市
	 * @param distract 传入酒店所属行政区
	 * @param tradingArea  传入商圈
	 * @return ArrayList<HotelInfoVO> 返回酒店列表
	 * @author all
	 */
	public ArrayList<HotelVO> getInitialHotelList(String city, String tradingArea) {
		ArrayList<HotelPO> hotelPOList = null;
		
		try {
			hotelPOList = hotelDao.SearchHotelList(city, tradingArea);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		ArrayList<HotelVO> hotelVOList = new ArrayList<HotelVO>();
		
		for (HotelPO hotelPO : hotelPOList) {
			hotelVOList.add(HotelTransform.hotelTransToVO(hotelPO));
		}
		
		return hotelVOList;
	}

	/**
	 * 将搜索到的酒店按一定方式排列
	 * @param HotelSerchCondition   传入需要排序的标准
	 * @param ArrayList<HotelVO>   传入需要排序的酒店列表
	 * @return ArrayList<HotelInfoVO> 返回按一定方式排序的酒店列表
	 * @author all
	 */
	public ArrayList<HotelVO> getSortedList(HotelSearchCondition condition, ArrayList<HotelVO> hotels) {
		
		if (condition == null || hotels == null) {
			System.out.println("logic.hotel.SearchHotel.getSortedList参数错误");
			return null;
		}
		
		if (hotels.size() == 1) {
			return hotels;
		}
		
		this.hotelSort = HotelSortFactory.getInstance().createHotelSort(condition);
		
		return this.hotelSort.getSortedList(hotels);
	}

	/**
	 * 获取用户预定过的酒店列表
	 * @param userID   传入用户id
	 * @return ArrayList<HotelInfoVO> 返回用户预定过的酒店列表
	 * @author all
	 */
	public ArrayList<HotelVO> getBookedHotelList(String userID) {
		ArrayList<String> hotelIds = orderHotelInfo.getBookedHotelList(userID);
		
		ArrayList<HotelVO> bookedHotelList = new ArrayList<HotelVO>();
		
		for (String hotelId : hotelIds) {
			try {
				bookedHotelList.add(HotelTransform.hotelTransToVO(hotelDao.getHotelInfoByHotelID(hotelId)));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return bookedHotelList;
	}

	/**
	 * 返回指定的酒店信息
	 * @param search 传入的VO信息
	 * @return HotelInfoVO 返回指定的酒店信息
	 * @author all
	 */
	@Override
	public ArrayList<HotelVO> search(HotelSearchVO search) {
		

		if (search == null || search.city == null || search.city.equals("") || search.tradingArea == null 
				|| search.tradingArea.equals("")||search.starLow > search.starHigh
				|| search.commentLow > search.commentHigh || search.roomPriceLow > search.roomPriceHigh) {
System.out.println("logic.hotel.SearchHotel.search参数错误");
			return null;
		}
		
		
		ArrayList<HotelVO> initList = getInitialHotelList(search.city, search.tradingArea);
		if (initList == null || initList.size() == 0) {
			return null;
		}

		
		ArrayList<HotelVO> hotelList  = new ArrayList<HotelVO>();	
		//酒店名称的筛选
		if (search.hotelName != null && !search.hotelName.equals("")) {
			
			System.out.println(search.hotelName + "bb");
			
			for (int i=0; i<initList.size(); ++i) {
				HotelVO hotelVO = initList.get(i); 
				if (hotelVO.hotelName == search.hotelName) {
					hotelList.add(hotelVO);
				}
			}
		} else {
			hotelList = initList;
		}
		
		if(hotelList == null || hotelList.size() == 0) {
			return null;
		}
		
		if(search.startTime != null && !search.startTime.equals("") 
				&& search.endTime != null && !search.endTime.equals("")) {
			
			ArrayList<HotelVO> hotelList2  = new ArrayList<HotelVO>();
	
			//筛选指定房间类型和指定时间的空房
			RoomInfo roomInfo = new Room();
			int num = 0;
			
			for(int i=0; i<hotelList.size(); ++i) {
				HotelVO vo  = hotelList.get(i);
				boolean empty = true;
				Time t1 = new Time(search.startTime);
				Time t2 = new Time(search.endTime);
				
				while(!t1.getTime().equals(t2.getTime())) {
					num = roomInfo.getSpcificTimeRemainingRoomNums(vo.hoteID, search.roomType, t1.getTime());
			
					
					if(num < search.roomNum) {
						empty = false;
						break;
					}
					
					t1 = t1.nextDay();
				}
				
				if(empty) {
					hotelList2.add(vo);
				}
			}
			
			hotelList = hotelList2;
		}
		
		
		
		if(hotelList == null || hotelList.size() == 0) {
			return null;
		}
	
		
		if (search.starLow >= 0 && search.starLow <= 5 && search.starHigh >= 0 && search.starHigh <= 5) {
			this.hotelSort = new StarSort();
			hotelList = this.hotelSort.getSpecificSectionHotelList(search.starLow, search.starHigh, hotelList);
		}
		if(hotelList == null || hotelList.size() == 0) {
			return null;
		}
		
		if (search.roomPriceLow != -1) {
			this.hotelSort = new PriceSort();
			hotelList = this.hotelSort.getSpecificSectionHotelList(search.roomPriceLow, search.roomPriceHigh, hotelList);
		}
		if(hotelList == null || hotelList.size() == 0) {
			return null;
		}
		
		
		if (search.commentLow >= 0 && search.commentLow <= 5 || search.commentHigh > 0 && search.commentHigh <= 5) {
			this.hotelSort = new GradeSort();
			hotelList = this.hotelSort.getSpecificSectionHotelList(search.commentLow, search.commentHigh, hotelList);
		}
		if(hotelList == null || hotelList.size() == 0) {
			return null;
		}
		
		
		return hotelList;
	}

}
