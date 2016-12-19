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
		System.out.println(Time.getCurrentTime());
	}
	
	@Test
	public void testGetCurrentTime() {
		
		assertEquals("2016-11-11 00:00:00", time.getTime());
	}
	
	
	@Test
	public void testInitTime() {
		assertEquals(2016, time.getYear());
		assertEquals(11, time.getDay());
		assertEquals(0, time.getSec());
	}
	
	
	@Test
	public void testCalculateDay() {
		assertEquals(0, new Time(Time.getCurrentTime().substring(0, 10)).calculateDay(Time.getCurrentTime()));
		
		
		assertEquals(1, new Time(Time.getCurrentTime().substring(0, 10)).nextDay().calculateDay(Time.getCurrentTime()));
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

	@Test
	public void testNextDay() {
		assertEquals("2016-11-11 12:00:00", new Time("2016-11-10 12:00:00").nextDay().getTime());
		
		assertEquals("2016-11-01 12:00:00", new Time("2016-10-31 12:00:00").nextDay().getTime());
	}
	
	@Test
	public void testCalculateLastestExecutedTime() {
		assertEquals("2016-11-11 16:00:00", new Time("2016-11-11 12:00:00").calculateLastestExecutedTime());
		
		assertEquals("2016-11-03 02:00:00", new Time("2016-11-02 22:00:00").calculateLastestExecutedTime());
	}
	

}
