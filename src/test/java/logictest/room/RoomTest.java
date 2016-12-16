package logictest.room;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import Message.ResultMessage;
import Message.RoomType;
import logic.room.Room;
import logic.utility.Time;
import vo.RoomVO;

public class RoomTest {

	private Room room;
	
	@Before
	public void setUp(){
		room = new Room();
	}
	
	@Test
	public void testGetRoomList(){
		assertEquals(4, this.room.getRoomList("00002").size());
		
		assertEquals(RoomType.SINGLE_ROOM, this.room.getRoomList("00002").get(1).roomType);
		
		assertEquals(3, this.room.getRoomList("00002").get(2).roomNum);
	}
	
	@Test
	public void testRoomInfo(){
		assertEquals(400, this.room.getRoomInfo("00002", RoomType.STANDARD_ROOM).price, 0);
	}
	
	@Test
	public void testUpdateRoomInfo(){
		assertEquals(ResultMessage.SUCCESS, this.room.updateRoomInfo(new RoomVO("00002", RoomType.STANDARD_ROOM, 10, 500)));
	}
	
	@Test
	public void testGetSpcificTimeRemainingRoomNums1(){
		String t = new Time(Time.getCurrentTime()).nextDay().getTime();
		assertEquals(0, this.room.getSpcificTimeRemainingRoomNums("00001", RoomType.TRIPLE_ROOM, t));
	}
	
	@Test
	public void testGetSpcificTimeRemainingRoomNums2(){
		assertEquals(7, this.room.getSpcificTimeRemainingRoomNums("00002", RoomType.STANDARD_ROOM, "2016-12-26 12:00:00"));
	}
	
	@Test
	public void testGetSpcificTimeRemainingRoomNums3(){
		assertEquals(20, this.room.getSpcificTimeRemainingRoomNums("00003", RoomType.SINGLE_ROOM, "2017-01-03 12:00:00"));
	}
	
	
	@Test
	public void testGetRoomPrice1(){
		assertEquals(1200, this.room.getRoomPrice("00001", RoomType.STANDARD_ROOM), 0);
	}
	
	@Test
	public void testGetRoomPrice2(){
		assertEquals(400, this.room.getRoomPrice("00002", RoomType.SINGLE_ROOM), 0);
	}
	
	@Test
	public void testGetRoomPrice3(){
		assertEquals(400, this.room.getRoomPrice("00003", RoomType.STANDARD_ROOM), 0);
	}
	
	@Test
	public void testGetHotelLowestPrice1(){
		assertEquals(250, this.room.getHotelLowestPrice("00001"),0);
	}
	
	@Test
	public void testGetHotelLowestPrice2(){
		assertEquals(200, this.room.getHotelLowestPrice("00002"), 0);
	}
	
	@Test
	public void testGetHotelLowestPrice3(){
		assertEquals(400, this.room.getHotelLowestPrice("00003"), 0);
	}
	
}
