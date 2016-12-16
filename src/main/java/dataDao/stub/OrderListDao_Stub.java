package dataDao.stub;

import java.util.ArrayList;

import Message.RoomType;
import dataDao.order.OrderListDao;
import po.OrderPO;

public class OrderListDao_Stub implements OrderListDao{

	@Override
	public ArrayList<OrderPO> getOrderListByUserId(String userID) {
		
		String[] r1 = {"109"};
		OrderPO po1 = new OrderPO("wyy", "20161231000060876", "00006", "2016-12-31 12:00:00",
				"2017-01-01 12:00:00", r1, 1, RoomType.BIGBED_ROOM.ordinal(), false, 1, 1, 300, 240, "ppp", null, null, null, null, null);
		;
		OrderPO po2 = new OrderPO("wyy", "20161212000041212", "00004", "2016-12-12 12:00:00",
				"2016-12-13 12:00:00", r1,1, RoomType.STANDARD_ROOM.ordinal(), false, 1, 0, 400, 320, "ppp", null, null, null, null, null);
		
		OrderPO po3 = new OrderPO("wyy", "20160808000060634", "00006", "2016-08-08 12:00:00",
				"2016-08-09 12:00:00", r1,1, RoomType.SINGLE_ROOM.ordinal(), false, 1, 4, 300, 240, "ppp", null, null, null, null, null);
		
		OrderPO po4 = new OrderPO("wyy", "20150214000070886", "00007", "2015-02-14 12:00:00",
				"2015-02-15 12:00:00", r1,1, RoomType.SUITE.ordinal(), false, 1, 2, 500, 400, "ppp", null, null, null, null, null);
		
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>();
		pos.add(po1);
		pos.add(po2);
		pos.add(po3);
		pos.add(po4);
		
		return pos;
	}

	@Override
	public ArrayList<OrderPO> getOrderListByHotelID(String hotelID) {

		String[] r2 = {"1008"};
		OrderPO po1 = new OrderPO("wyy", "20161231000060876", "00006", "2016-12-31 12:00:00",
				"2017-01-01 12:00:00", r2,1, RoomType.STANDARD_ROOM.ordinal(), false, 1, 1, 300, 240, "ppp", null, null, null, null, null);
		
		OrderPO po2 = new OrderPO("bcy", "20161212000061212", "00006", "2016-12-12 12:00:00",
				"2016-12-13 12:00:00", r2,1, RoomType.STANDARD_ROOM.ordinal(), false, 1, 0, 400, 320, "ppp", null, null, null, null, null);
		
		OrderPO po3 = new OrderPO("wyy", "20160808000060634", "00006", "2016-08-08 12:00:00",
				"2016-08-09 12:00:00", r2,1, RoomType.BIGBED_ROOM.ordinal(), false, 1, 4, 300, 240, "ppp",null, null, null, null, null);
		
		OrderPO po4 = new OrderPO("zdy", "20150214000060886", "00006", "2015-02-14 12:00:00",
				"2015-02-15 12:00:00", r2,1, RoomType.STANDARD_ROOM.ordinal(), false, 1, 2, 500, 400, "ppp", null, null, null, null, null);
		
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>();
		pos.add(po1);
		pos.add(po2);
		pos.add(po3);
		pos.add(po4);
		
		return pos;
	}

	@Override
	public ArrayList<OrderPO> getAllDailyOrders(String time) {

		String[] r2 = {"1508"};
		
		OrderPO po1 = new OrderPO("wyy", "2016123100030876", "00003", "2016-12-31 12:00:00",
				"2017-01-01 12:00:00", r2, 1, RoomType.BIGBED_ROOM.ordinal(), false, 1, 1, 300, 240, "ppp", null, null, null, null, null);
		
		OrderPO po2 = new OrderPO("bcy", "20161212000051212", "00005", "2016-12-12 12:00:00",
				"2016-12-13 12:00:00", r2,1, RoomType.SINGLE_ROOM.ordinal(), false, 1, 0, 400, 320, "ppp", null, null, null, null, null);
		
		OrderPO po3 = new OrderPO("wx", "20160808000060634", "00006", "2016-08-08 12:00:00",
				"2016-08-09 12:00:00", r2,1, RoomType.STANDARD_ROOM.ordinal(), false, 1, 4, 300, 240, "ppp", null, null, null, null, null);
		
		OrderPO po4 = new OrderPO("zdy", "20150214000190886", "00019", "2015-02-14 12:00:00",
				"2015-02-15 12:00:00", r2,1, RoomType.STANDARD_ROOM.ordinal(), false, 1, 2, 500, 400, "ppp", null, null, null, null, null);
		
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>();
		pos.add(po1);
		pos.add(po2);
		pos.add(po3);
		pos.add(po4);
		
		return pos;
	}

}
