package de.mccityville.common.bukkit.utils.config;

import java.util.Map;

public class ConfigurationCaster {
	
	private final Map<String, Object> data;
	
	public ConfigurationCaster(Map<String, Object> data) {
		this.data = data;
	}
	
	public Object get(String key, Object defaultValue) {
		return get(key, false, defaultValue);
	}
	
	public Object get(String key, boolean required, Object defaultValue) {
		Object o = data.get(key);
		
		if (o == null) {
			if (required)
				throw new UnsupportedOperationException("Key " + key + " required.");
			
			o = defaultValue;
		}
		
		return o;
	}
	
	public <T> T get(String key, boolean required, T defaultValue, Class<T> castTarget) {
		Object o = get(key, required, defaultValue);
		
		return castTarget.cast(o);
	}
	
	public <T> T require(String key, T defaultValue, Class<T> castTarget) {
		return get(key, false, defaultValue, castTarget);
	}
	
	public String getString(String key) {
		return getString(key, null);
	}
	
	public String getString(String key, String defaultValue) {
		return get(key, false, defaultValue, String.class);
	}
	
	public String requireString(String key) {
		return get(key, true, null, String.class);
	}
	
	public Integer getInteger(String key) {
		return getInteger(key, null);
	}
	
	public Integer getInteger(String key, Integer defaultValue) {
		return get(key, false, defaultValue, Integer.class);
	}
	
	public int requireInteger(String key) {
		return require(key, null, Integer.class);
	}
	
	public Double getDouble(String key) {
		return getDouble(key, null);
	}
	
	public Double getDouble(String key, Double defaultValue) {
		return get(key, false, defaultValue, Double.class);
	}
	
	public double requireDouble(String key) {
		return require(key, null, Double.class);
	}
	
	public Boolean getBoolean(String key) {
		return getBoolean(key, null);
	}
	
	public Boolean getBoolean(String key, Boolean defaultValue) {
		return get(key, false, defaultValue, Boolean.class);
	}
	
	public boolean requireBoolean(String key) {
		return require(key, null, Boolean.class);
	}
}
