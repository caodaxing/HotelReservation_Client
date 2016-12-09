package logictest.utility;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import logic.utility.Time;

public class TimeTest {

	private Time time;
	
	@Before
	public void setUp() {
		this.time = new Time("2016-11-11");
	}
	
	@Test
	public void testGetCurrentTime() {
		assertEquals("2016-12-09", Time.getCurrentTime().substring(0, 10));
		
		assertEquals("2016-11-11 00:00:00", time.getTime());
	}
	
	@Test
	public void testInitTime() {
		assertEquals(2016, time.getYear());
		assertEquals(11, time.getDay());
		assertEquals(0, time.getSec());
	}
	
	@Test
	public void testBefore() {
		assertEquals(true, time.before(new Time("2016-11-11 00:00:01")));
		
		assertEquals(false, time.before(new Time("2015-11-11")));
	}
	

	@Test
	public void testAfter() {
		assertEquals(true, time.after(new Time("2016-11-10 23:59:59")));
		
		assertEquals(false, time.after(new Time("2017-11-10")));
	}

}
