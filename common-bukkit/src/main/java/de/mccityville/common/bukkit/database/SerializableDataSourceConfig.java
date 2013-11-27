package de.mccityville.common.bukkit.database;

import java.util.Map;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import com.avaje.ebean.config.DataSourceConfig;
import com.google.common.collect.Maps;

import de.mccityville.common.bukkit.utils.config.ConfigurationCaster;

public class SerializableDataSourceConfig extends DataSourceConfig implements ConfigurationSerializable {
	
	private static final DataSourceConfig UNIT_CONFIG = new DataSourceConfig();
	private static final String CONFIG_CSTMTCACHESIZE = "cstmtCacheSize";
	private static final String CONFIG_DRIVER = "driver";
	private static final String CONFIG_HEARTBEATSQL = "heartbeatSql";
	private static final String CONFIG_MAXCONNECTIONS = "maxConnections";
	private static final String CONFIG_MAXINACTIVETIMESECONDS = "maxInactiveTimeSeconds";
	private static final String CONFIG_MINCONNECTIONS = "minConnections";
	private static final String CONFIG_URL = "url";
	private static final String CONFIG_USERNAME = "username";
	private static final String CONFIG_PASSWORD = "password";
	
	public Map<String, Object> serialize() {
		Map<String, Object> data = Maps.newHashMap();
		
		data.put(CONFIG_URL, getUrl());
		data.put(CONFIG_DRIVER, getDriver());
		data.put(CONFIG_USERNAME, getUsername());
		data.put(CONFIG_PASSWORD, getPassword());
		
		if (getCstmtCacheSize() != UNIT_CONFIG.getCstmtCacheSize())
			data.put(CONFIG_CSTMTCACHESIZE, getCstmtCacheSize());
		
		if (!getHeartbeatSql().equals(UNIT_CONFIG.getHeartbeatSql()))
			data.put(CONFIG_HEARTBEATSQL, getHeartbeatSql());
		
		if (getMinConnections() != UNIT_CONFIG.getMinConnections())
			data.put(CONFIG_MINCONNECTIONS, getMinConnections());
		
		if (getMaxConnections() != UNIT_CONFIG.getMaxConnections())
			data.put(CONFIG_MAXCONNECTIONS, getMaxConnections());
		
		if (getMaxInactiveTimeSecs() != UNIT_CONFIG.getMaxInactiveTimeSecs())
			data.put(CONFIG_MAXINACTIVETIMESECONDS, getMaxInactiveTimeSecs());
		
		return data;
	}
	
	public static SerializableDataSourceConfig deserialize(Map<String, Object> data) {
		SerializableDataSourceConfig config = new SerializableDataSourceConfig();
		ConfigurationCaster caster = new ConfigurationCaster(data);
		
		config.setUrl(caster.getString(CONFIG_URL));
		config.setDriver(caster.getString(CONFIG_DRIVER));
		config.setUsername(caster.getString(CONFIG_USERNAME));
		config.setPassword(caster.getString(CONFIG_PASSWORD));
		config.setCstmtCacheSize(caster.getInteger(CONFIG_CSTMTCACHESIZE, UNIT_CONFIG.getCstmtCacheSize()));
		config.setHeartbeatSql(caster.getString(CONFIG_HEARTBEATSQL, UNIT_CONFIG.getHeartbeatSql()));
		config.setMinConnections(caster.getInteger(CONFIG_MINCONNECTIONS, UNIT_CONFIG.getMinConnections()));
		config.setMaxConnections(caster.getInteger(CONFIG_MAXCONNECTIONS, UNIT_CONFIG.getMaxConnections()));
		config.setMaxInactiveTimeSecs(caster.getInteger(CONFIG_MAXINACTIVETIMESECONDS, UNIT_CONFIG.getMaxInactiveTimeSecs()));
		
		return config;
	}
}
