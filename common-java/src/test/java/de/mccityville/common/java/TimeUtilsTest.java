package de.mccityville.common.java;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

public class TimeUtilsTest {
	
	@Test
	public void testTimeUnitParser() {
		long minutes = 5;
		long seconds = 15;
		String str = minutes + "m" + seconds + "s";
		
		long sum = TimeUtils.parseTimeToSeconds(str);
		
		Assert.assertEquals(TimeUnit.MINUTES.toSeconds(minutes) + seconds, sum);
	}
}
