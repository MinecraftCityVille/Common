package de.mccityville.common.bukkit;

import java.util.Map;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import com.google.common.collect.Maps;

import de.mccityville.common.bukkit.utils.config.ConfigurationCaster;

public class DatabaseAssignmentConfiguration implements ConfigurationSerializable {
	
	private static final String CONFIG_PLAYERDBCONNECTION = "playerDbConnection";
	
	private String playerDbConnection = "default";
	
	public void setPlayerDbConnection(String playerDbConnection) {
		this.playerDbConnection = playerDbConnection;
	}
	
	public String getPlayerDbConnection() {
		return playerDbConnection;
	}
	
	public Map<String, Object> serialize() {
		Map<String, Object> data = Maps.newHashMap();
		
		data.put(CONFIG_PLAYERDBCONNECTION, playerDbConnection);
		
		return data;
	}
	
	public static DatabaseAssignmentConfiguration deserialize(Map<String, Object> data) {
		DatabaseAssignmentConfiguration config = new DatabaseAssignmentConfiguration();
		ConfigurationCaster caster = new ConfigurationCaster(data);
		
		config.setPlayerDbConnection(caster.getString(CONFIG_PLAYERDBCONNECTION, config.getPlayerDbConnection()));
		
		return config;
	}
}
