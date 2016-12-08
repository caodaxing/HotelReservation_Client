package dataDao.stub;

import java.util.ArrayList;

import dataDao.order.OrderListDao;
import po.OrderPO;

public class OrderListDao_Stub implements OrderListDao{

	@Override
	public ArrayList<OrderPO> getOrderListByUserId(String userID) {
		
		ArrayList<String> r1 = new ArrayList<String>();
		r1.add("1223");
		ArrayList<String> p1 = new ArrayList<String>();
		p1.add("ppp");
		OrderPO po1 = new OrderPO("wyy", "20161231000060876", "00006", "2016-12-31 12:00:00",
				"2017-01-01 12:00:00", 1, r1, false, 1, 1, 300, 240, 1, p1, null, null, null);
		
		ArrayList<String> r2 = new ArrayList<String>();
		r2.add("1109");
		ArrayList<String> p2 = new ArrayList<String>();
		p2.add("ppp");
		OrderPO po2 = new OrderPO("wyy", "20161212000041212", "00004", "2016-12-12 12:00:00",
				"2016-12-13 12:00:00", 1, r2, false, 1, 0, 400, 320, 1, p2, null, null, null);
		
		ArrayList<String> r3 = new ArrayList<String>();
		r3.add("3478");
		ArrayList<String> p3 = new ArrayList<String>();
		p3.add("ppp");
		OrderPO po3 = new OrderPO("wyy", "20160808000060634", "00006", "2016-08-08 12:00:00",
				"2016-08-09 12:00:00", 1, r3, false, 1, 3, 300, 240, 1, p3, null, null, null);
		
		ArrayList<String> r4 = new ArrayList<String>();
		r4.add("0976");
		ArrayList<String> p4 = new ArrayList<String>();
		p4.add("ppp");
		OrderPO po4 = new OrderPO("wyy", "20150214000070886", "00007", "2015-02-14 12:00:00",
				"2015-02-15 12:00:00", 1, r4, false, 1, 2, 500, 400, 1, p4, null, null, null);
		
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>();
		pos.add(po1);
		pos.add(po1);
		pos.add(po3);
		pos.add(po4);
		
		return pos;
	}

	@Override
	public ArrayList<OrderPO> getOrderListByHotelID(String hotelID) {

		ArrayList<String> r1 = new ArrayList<String>();
		r1.add("1223");
		ArrayList<String> p1 = new ArrayList<String>();
		p1.add("ppp");
		OrderPO po1 = new OrderPO("wyy", "20161231000060876", "00006", "2016-12-31 12:00:00",
				"2017-01-01 12:00:00", 1, r1, false, 1, 1, 300, 240, 1, p1, null, null, null);
		
		ArrayList<String> r2 = new ArrayList<String>();
		r2.add("1109");
		ArrayList<String> p2 = new ArrayList<String>();
		p2.add("ppp");
		OrderPO po2 = new OrderPO("bcy", "20161212000061212", "00006", "2016-12-12 12:00:00",
				"2016-12-13 12:00:00", 1, r2, false, 1, 0, 400, 320, 1, p2, null, null, null);
		
		ArrayList<String> r3 = new ArrayList<String>();
		r3.add("3478");
		ArrayList<String> p3 = new ArrayList<String>();
		p3.add("ppp");
		OrderPO po3 = new OrderPO("wyy", "20160808000060634", "00006", "2016-08-08 12:00:00",
				"2016-08-09 12:00:00", 1, r3, false, 1, 3, 300, 240, 1, p3, null, null, null);
		
		ArrayList<String> r4 = new ArrayList<String>();
		r4.add("0976");
		ArrayList<String> p4 = new ArrayList<String>();
		p4.add("ppp");
		OrderPO po4 = new OrderPO("zdy", "20150214000060886", "00006", "2015-02-14 12:00:00",
				"2015-02-15 12:00:00", 1, r4, false, 1, 2, 500, 400, 1, p4, null, null, null);
		
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>();
		pos.add(po1);
		pos.add(po1);
		pos.add(po3);
		pos.add(po4);
		
		return pos;
	}

	@Override
	public ArrayList<OrderPO> getAllDailyOrders(String time) {

		ArrayList<String> r1 = new ArrayList<String>();
		r1.add("1223");
		ArrayList<String> p1 = new ArrayList<String>();
		p1.add("ppp");
		OrderPO po1 = new OrderPO("wyy", "2016123100030876", "00003", "2016-12-31 12:00:00",
				"2017-01-01 12:00:00", 1, r1, false, 1, 1, 300, 240, 1, p1, null, null, null);
		
		ArrayList<String> r2 = new ArrayList<String>();
		r2.add("1109");
		ArrayList<String> p2 = new ArrayList<String>();
		p2.add("ppp");
		OrderPO po2 = new OrderPO("bcy", "20161212000051212", "00005", "2016-12-12 12:00:00",
				"2016-12-13 12:00:00", 1, r2, false, 1, 0, 400, 320, 1, p2, null, null, null);
		
		ArrayList<String> r3 = new ArrayList<String>();
		r3.add("3478");
		ArrayList<String> p3 = new ArrayList<String>();
		p3.add("ppp");
		OrderPO po3 = new OrderPO("wx", "20160808000060634", "00006", "2016-08-08 12:00:00",
				"2016-08-09 12:00:00", 1, r3, false, 1, 3, 300, 240, 1, p3, null, null, null);
		
		ArrayList<String> r4 = new ArrayList<String>();
		r4.add("0976");
		ArrayList<String> p4 = new ArrayList<String>();
		p4.add("ppp");
		OrderPO po4 = new OrderPO("zdy", "20150214000190886", "00019", "2015-02-14 12:00:00",
				"2015-02-15 12:00:00", 1, r4, false, 1, 2, 500, 400, 1, p4, null, null, null);
		
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>();
		pos.add(po1);
		pos.add(po1);
		pos.add(po3);
		pos.add(po4);
		
		return pos;
	}

}
