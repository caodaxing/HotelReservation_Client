package logictest.promotion;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Message.RoomType;
import logic.promotion.CalculatePromotion;
import vo.OrderVO;
import vo.RoomVO;

public class CalculatePromotionTest {

	private CalculatePromotion calculatePromotion;
	
	@Before
	public void setUp() {
		this.calculatePromotion = new CalculatePromotion();
	}
	
	//HotelBirthday + WebVipLevel + WebTradingArea + Web11 + Hotel11
	@Test
	public void testCalculatePromotion1() {
		ArrayList<RoomVO> rooms = new ArrayList<RoomVO>();
		rooms.add(new RoomVO("00001", "1101", RoomType.STANDARD_ROOM, 400, false, null));
		OrderVO vo = new OrderVO("wyy", "2016-11-11 12:00:00", "2016-11-12 12:00:00", "00001", rooms, 2, false, 400);
		
		OrderVO order = this.calculatePromotion.calculatePromotion(vo);
		
		assertEquals(5, order.promotions.size());
		
		assertEquals(122.89, 0.00, order.afterPrice);
	}
	
	
	//HotelBirthday + WebVipLevel + WebTradingArea + HotelThreeRooms
	@Test
	public void testCalculatePromotion2() {
		ArrayList<RoomVO> rooms = new ArrayList<RoomVO>();
		rooms.add(new RoomVO("00001", "1101", RoomType.STANDARD_ROOM, 400, false, null));
		rooms.add(new RoomVO("00001", "1102", RoomType.STANDARD_ROOM, 300, false, null));
		rooms.add(new RoomVO("00001", "1103", RoomType.STANDARD_ROOM, 500, false, null));
		OrderVO vo = new OrderVO("wyy", "2016-11-30 12:00:00", "2016-11-31 12:00:00", "00001", rooms, 4, false, 1200);
		
		OrderVO order = this.calculatePromotion.calculatePromotion(vo);
		
		assertEquals(4, order.promotions.size());
		
		assertEquals(622.08, 0.00, order.afterPrice);
	}
	
	//HotelBirthday + WebVipLevel + WebTradingArea + HotelThreeRooms
	@Test
	public void testCalculatePromotion3() {
		ArrayList<RoomVO> rooms = new ArrayList<RoomVO>();
		rooms.add(new RoomVO("00001", "1101", RoomType.STANDARD_ROOM, 400, false, null));
		rooms.add(new RoomVO("00001", "1102", RoomType.STANDARD_ROOM, 300, false, null));
		rooms.add(new RoomVO("00001", "1103", RoomType.STANDARD_ROOM, 500, false, null));
		rooms.add(new RoomVO("00001", "1105", RoomType.STANDARD_ROOM, 300, false, null));
		OrderVO vo = new OrderVO("wyy", "2016-11-30 12:00:00", "2016-11-31 12:00:00", "00001", rooms, 4, false, 1500);
		
		OrderVO order = this.calculatePromotion.calculatePromotion(vo);
		
		assertEquals(4, order.promotions.size());
		
		assertEquals(552.96, 0.00, order.afterPrice);
		
	}
	
	//HotelBusiness + WebVipLevel + WebTradingArea
	@Test
	public void testCalculatePromotion4() {
		ArrayList<RoomVO> rooms = new ArrayList<RoomVO>();
		rooms.add(new RoomVO("00001", "1101", RoomType.STANDARD_ROOM, 400, false, null));
		OrderVO vo = new OrderVO("bcy", "2015-11-11 12:00:00", "2015-11-12 12:00:00", "00001", rooms, 2, false, 400);
		
		OrderVO order = this.calculatePromotion.calculatePromotion(vo);
		
		assertEquals(3, order.promotions.size());
		
		assertEquals(179.20, 0.00, order.afterPrice);
	}

}
