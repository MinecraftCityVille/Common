package de.mccityville.common.bukkit.database;

import java.util.Map;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import com.avaje.ebean.config.ServerConfig;
import com.google.common.collect.Maps;

import de.mccityville.common.bukkit.utils.config.ConfigurationCaster;

public class SerializableServerConfig extends ServerConfig implements ConfigurationSerializable {
	
	private static final ServerConfig UNIT_CONFIG = new ServerConfig();
	private static final String CONFIG_NAME = "name";
	private static final String CONFIG_REGISTER = "register";
	private static final String CONFIG_DEFAULTSERVER = "defaultServer";
	private static final String CONFIG_DATASOURCE = "datasource";
	
	private SerializableDataSourceConfig dataSource = new SerializableDataSourceConfig();
	
	public Map<String, Object> serialize() {
		Map<String, Object> data = Maps.newHashMap();
		
		if (!getName().equals(UNIT_CONFIG.getName()))
			data.put(CONFIG_NAME, getName());
		
		if (isRegister() != UNIT_CONFIG.isRegister())
			data.put(CONFIG_REGISTER, isRegister());
		
		if (isDefaultServer() != UNIT_CONFIG.isDefaultServer())
			data.put(CONFIG_DEFAULTSERVER, isDefaultServer());
		
		data.put(CONFIG_DATASOURCE, dataSource);
		
		return data;
	}
	
	public static SerializableServerConfig deserialize(Map<String, Object> data) {
		SerializableServerConfig config = new SerializableServerConfig();
		ConfigurationCaster caster = new ConfigurationCaster(data);
		
		config.setName(caster.requireString(CONFIG_NAME));
		config.setRegister(caster.getBoolean(CONFIG_REGISTER, UNIT_CONFIG.isRegister()));
		config.setDefaultServer(caster.getBoolean(CONFIG_DEFAULTSERVER, UNIT_CONFIG.isDefaultServer()));
		config.setDataSourceConfig(caster.get(CONFIG_DATASOURCE, false, new SerializableDataSourceConfig(), SerializableDataSourceConfig.class));
		
		return config;
	}
}
