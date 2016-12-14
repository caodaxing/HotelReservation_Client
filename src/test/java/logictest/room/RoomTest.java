package logictest.room;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import Message.ResultMessage;
import Message.RoomType;
import logic.room.Room;
import vo.RoomVO;

public class RoomTest {

	private Room room;
	
	@Before
	public void setUp(){
		room = new Room();
	}
	
	@Test
	public void testGetRoomList(){
		assertEquals(3, this.room.getRoomList("00002").size());
		
		assertEquals(RoomType.SINGLE_ROOM, this.room.getRoomList("00002").get(1).roomType);
		
		assertEquals("1203", this.room.getRoomList("00002").get(2).roomId);
	}
	
	@Test
	public void testRoomInfo(){
		assertEquals(400, 0, this.room.getRoomInfo("00002", "1109").price);
	}
	
	@Test
	public void testUpdateRoomInfo(){
		HashMap<String, String> n = new HashMap<String, String>();
		n.put("2016-12-20 12:00:00", "2016-12-21 12:00:00");
		assertEquals(ResultMessage.SUCCESS, this.room.updateRoomInfo(new RoomVO("00002", "1109", RoomType.STANDARD_ROOM, 500, n, null)));
	}
	
	@Test
	public void testGetSpcificTimeRemainingRoomNums1(){
		assertEquals(1, this.room.getSpcificTimeRemainingRoomNums("00001", RoomType.STANDARD_ROOM, "2016-12-25 12:00:00"));
	}
	
	@Test
	public void testGetSpcificTimeRemainingRoomNums2(){
		assertEquals(3, this.room.getSpcificTimeRemainingRoomNums("00001", RoomType.STANDARD_ROOM, "2016-12-26 12:00:00"));
	}
	
	@Test
	public void testGetSpcificTimeRemainingRoomNums3(){
		assertEquals(0, this.room.getSpcificTimeRemainingRoomNums("00002", RoomType.SINGLE_ROOM, "2017-01-03 12:00:00"));
	}
	
	
	@Test
	public void testGetRoomPrice1(){
		assertEquals(400, 0, this.room.getRoomPrice("00001", RoomType.STANDARD_ROOM));
	}
	
	@Test
	public void testGetRoomPrice2(){
		assertEquals(0, 0, this.room.getRoomPrice("00001", RoomType.SINGLE_ROOM));
	}
	
	@Test
	public void testGetRoomPrice3(){
		assertEquals(500, 0, this.room.getRoomPrice("00002", RoomType.STANDARD_ROOM));
	}
}
