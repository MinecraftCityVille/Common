package de.mccityville.common.java.database;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang3.Validate;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.config.ServerConfig;
import com.google.common.collect.Maps;

public class EbeanServerManager {
	
	private final Map<String, EbeanServer> store = Maps.newHashMap();
	private EbeanServer defaultServer;
	
	public void initializeEbeanServer(Collection<ServerConfig> serverConfigs, ClassLoader classLoader) {
		for (EbeanServer server : EbeanServerUtils.create(serverConfigs, classLoader))
			addEbeanServer(server);
	}
	
	public void addEbeanServer(EbeanServer server) {
		Validate.notNull(server);
		
		if (store.size() == 0)
			defaultServer = server;
		
		store.put(server.getName(), server);
	}
	
	public void removeEbeanServer(String name) {
		store.remove(name);
		
		if (defaultServer != null && name.equals(defaultServer.getName()))
			defaultServer = null;
	}
	
	public EbeanServer getEbeanServer(String name) {
		Validate.notEmpty(name);
		
		return store.get(name);
	}
	
	public EbeanServer getEbeanServer() {
		return defaultServer;
	}
}