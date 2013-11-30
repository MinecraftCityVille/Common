package de.mccityville.common.bukkit;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import de.mccityville.common.bukkit.database.SerializableServerConfig;
import de.mccityville.common.bukkit.utils.config.ConfigurationCaster;

public class CommonPluginConfiguration implements ConfigurationSerializable {
	
	private static final String CONFIG_DBCONNECTIONS = "dbConnections";
	private static final String CONFIG_DBASSIGNMENTS = "dbAssignments";
	
	private final List<SerializableServerConfig> dbConnections = Lists.newArrayList();
	private DatabaseAssignmentConfiguration dbAssignments = new DatabaseAssignmentConfiguration();
	
	public List<SerializableServerConfig> getDbconnections() {
		return Collections.synchronizedList(dbConnections);
	}
	
	public void setDbAssignments(DatabaseAssignmentConfiguration dbAssignments) {
		this.dbAssignments = dbAssignments;
	}
	
	public DatabaseAssignmentConfiguration getDbAssignments() {
		return dbAssignments;
	}
	
	public Map<String, Object> serialize() {
		Map<String, Object> data = Maps.newHashMap();
		
		data.put(CONFIG_DBCONNECTIONS, dbConnections);
		data.put(CONFIG_DBASSIGNMENTS, dbAssignments);
		
		return data;
	}
	
	@SuppressWarnings("unchecked")
	public static CommonPluginConfiguration deserialize(Map<String, Object> data) {
		CommonPluginConfiguration config = new CommonPluginConfiguration();
		ConfigurationCaster caster = new ConfigurationCaster(data);
		
		config.dbConnections.addAll(caster.get(CONFIG_DBCONNECTIONS, false, config.getDbconnections(), List.class));
		config.setDbAssignments(caster.get(CONFIG_DBASSIGNMENTS, false, config.getDbAssignments(), DatabaseAssignmentConfiguration.class));
		
		return config;
	}
}
