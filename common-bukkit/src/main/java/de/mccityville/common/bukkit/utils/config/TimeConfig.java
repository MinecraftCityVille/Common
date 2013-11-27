package de.mccityville.common.bukkit.utils.config;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import com.google.common.collect.Maps;

public class TimeConfig implements ConfigurationSerializable {
	
	private static final String CONFIG_TIME = "time";
	private static final String CONFIG_UNIT = "unit";
	
	private long time;
	private TimeUnit unit;
	
	public void setTime(long time) {
		this.time = time;
	}
	
	public long getTime() {
		return time;
	}
	
	public void setUnit(TimeUnit unit) {
		this.unit = unit;
	}
	
	public TimeUnit getUnit() {
		return unit;
	}
	
	public Map<String, Object> serialize() {
		Map<String, Object> data = Maps.newHashMap();
		
		data.put(CONFIG_TIME, time);
		data.put(CONFIG_UNIT, unit.name());
		
		return data;
	}
	
	public static TimeConfig deserialize(Map<String, Object> data) {
		ConfigurationCaster caster = new ConfigurationCaster(data);
		TimeConfig config = new TimeConfig();
		
		config.setTime(caster.get(CONFIG_TIME, true, null, Long.class));
		config.setUnit(TimeUnit.valueOf(caster.requireString(CONFIG_UNIT)));
		
		return config;
	}
}
