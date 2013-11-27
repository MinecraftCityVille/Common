package de.mccityville.common.java;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TimeUtils {
	
	private static final Pattern TIMEPARSE_PATTERN = Pattern.compile("(\\d+)(s|m|h|d)", Pattern.CASE_INSENSITIVE);
	
	public static long parseTimeToSeconds(String timeString) {
		Matcher matcher = TIMEPARSE_PATTERN.matcher(timeString);
		long sum = 0;
		
		while (matcher.find())
			sum += getTimeUnit(matcher.group(2)).toSeconds(Long.parseLong(matcher.group(1)));
		
		return sum;
	}
	
	private static TimeUnit getTimeUnit(String str) {
		if ("s".equalsIgnoreCase(str))
			return TimeUnit.SECONDS;
		else if ("m".equalsIgnoreCase(str))
			return TimeUnit.MINUTES;
		else if ("h".equalsIgnoreCase(str))
			return TimeUnit.HOURS;
		else if ("d".equalsIgnoreCase(str))
			return TimeUnit.DAYS;
		
		throw new IllegalArgumentException("Unknown time unit: " + str);
	}
	
	private TimeUtils() { }
}
