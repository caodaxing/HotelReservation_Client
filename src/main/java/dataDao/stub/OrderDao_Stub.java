package dataDao.stub;

import java.util.ArrayList;

import Message.RoomType;
import dataDao.order.OrderDao;
import po.EvaluationPO;
import po.OrderPO;

public class OrderDao_Stub implements OrderDao {

	private ArrayList<OrderPO> pos = new ArrayList<OrderPO>();
	
	public OrderDao_Stub() {
		
		String[] r1 = {"1109"};
//		this.pos.add(new OrderPO("wyy", "20161212000041212", "green", "2016-12-12 12:00:00",
//				"2016-12-13 12:00:00",r1, 1, 1, false, 1, OrderState.UNEXECUTED.ordinal(), 300, 240, "ppp", null, null, null, null, null));
		
		String[] r2= {"123"};
//		this.pos.add(new OrderPO("wyy", "20170101000240001", "green", "2017-01-01 12:00:00",
//				"2017-01-02 12:00:00", r2,1, 2, false, 1, 2, 300, 240, "ppp", null, null, null, null, null));
		
		String[] r3= {"123"};
		String[] r4= {"503"};
		
//		this.pos.add(new OrderPO("wyy", "20160101000240001", "green", "2017-01-01 12:00:00",
//				"2017-01-02 12:00:00", r3,1, 2, false, 1, 0, 300, 240, "ppp", null, null, null, null, null));
		
		OrderPO po1 = new OrderPO("wyy", "20161231000060876", "00006", "2016-12-31 12:00:00",
				"2017-01-01 12:00:00", r1, 1, RoomType.BIGBED_ROOM.ordinal(), false, 1, 1, 300, 240, "ppp", null, null, null, null, null);
		
		OrderPO po2 = new OrderPO("wyy", "20161212000041212", "00004", "2017-01-09 12:00:00",
				"2017-01-09 12:00:00", r2,1, RoomType.STANDARD_ROOM.ordinal(), false, 1, 0, 400, 320, "ppp", null, null, null, null, null);
		
		OrderPO po3 = new OrderPO("wyy", "20160808000060634", "00006", "2016-08-08 12:00:00",
				"2016-08-09 12:00:00", r3,1, RoomType.SINGLE_ROOM.ordinal(), false, 1, 4, 300, 240, "ppp", null, null, null, null, null);
		
		OrderPO po4 = new OrderPO("wyy", "20150214000070886", "00007", "2015-02-14 12:00:00",
				"2015-02-15 12:00:00", r4,1, RoomType.SUITE.ordinal(), false, 1, 2, 500, 400, "ppp", null, null, null, null, null);
		
		OrderPO po5 = new OrderPO("wyy", "20150214000090900", "00008", "2015-02-14 12:00:00",
				"2015-02-15 12:00:00", r4,1, RoomType.SUITE.ordinal(), false, 1, 3, 500, 400, "ppp", null, null, null, null, null);
		
		this.pos.add(po1);
		this.pos.add(po2);
		this.pos.add(po3);
		this.pos.add(po4);
		this.pos.add(po5);
	}

	@Override
	public boolean addOrder(OrderPO orderPO) {
		return true;
	}

	@Override
	public boolean updateOrder(OrderPO orderPO) {
		return true;
	}

	@Override
	public OrderPO getOrderByOrderID(String orderID) {
		if(orderID == "20161231000060876") {
			return pos.get(0);
		} else if(orderID == "20161212000041212") {
			return pos.get(1);
		} else if(orderID == "20160808000060634") {
			return pos.get(2);
		}else if(orderID == "20150214000090900") {
			return pos.get(4);
		} 
		
		return pos.get(3);
	}

	@Override
	public boolean addEvaluation(EvaluationPO po) {
		return true;
	}

	@Override
	public EvaluationPO getEvaluationByOrderID(String orderID) {
		return new EvaluationPO("20161212000041212", 4.6, "爽");
	}

	@Override
	public ArrayList<EvaluationPO> getEvaluationByHotelID(String hotelID) {
		ArrayList<EvaluationPO> pos = new ArrayList<EvaluationPO>();
		pos.add(new EvaluationPO("20161212000041212", 4.6, "爽"));
		pos.add(new EvaluationPO("20160101000240001", 4.1, "不错"));
		return pos;
	}

	@Override
	public ArrayList<String> getBookedHotelList(String userID) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("00001");
		list.add("00002");
		
		return list;
	}

	@Override
	public int getOrderNum() {
		return 1889;
	}
}