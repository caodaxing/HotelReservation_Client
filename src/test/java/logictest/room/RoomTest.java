package logictest.room;

import static org.junit.Assert.assertEquals;

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
		assertEquals(ResultMessage.SUCCESS, this.room.updateRoomInfo(new RoomVO("00002", "1109", RoomType.STANDARD_ROOM, 500, true, null)));
	}
	
	@Test
	public void testGetRemainingRoomNums(){
		assertEquals(2, this.room.getRemainingRoomNums("00002", RoomType.STANDARD_ROOM));
	}
	
	
	
}
