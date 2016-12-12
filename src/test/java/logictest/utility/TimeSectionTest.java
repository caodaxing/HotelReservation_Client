package logictest.utility;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import logic.utility.TimeSection;

public class TimeSectionTest {

	private TimeSection section;
	
	@Before
	public void setUp() {
		this.section = new TimeSection("2016-10-31 12:00:00", "2016-11-02 12:00:00");
	}
	
	@Test
	public void testIncludeTime1() {
		assertEquals(true, this.section.includeTime("2016-10-31 12:00:00"));
	}
	
	@Test
	public void testIncludeTime2() {
		assertEquals(false, this.section.includeTime("2016-10-30 12:00:00"));
	}

	@Test
	public void testIncludeTime3() {
		assertEquals(false, this.section.includeTime("2016-11-02 12:00:00"));
	}
	
	@Test
	public void testIncludeTime4() {
		assertEquals(true, this.section.includeTime("2016-11-01 12:00:00"));
	}

	@Test
	public void testIncludeTime5() {
		assertEquals(false, this.section.includeTime("2016-11-08 12:00:00"));
	}


}
