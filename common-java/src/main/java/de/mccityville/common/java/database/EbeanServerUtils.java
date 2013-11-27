package de.mccityville.common.java.database;

import java.util.Collection;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.ServerConfig;
import com.google.common.collect.ImmutableList;

public final class EbeanServerUtils {
	
	public static EbeanServer create(ServerConfig config, ClassLoader context) {
		ClassLoader previousClassLoader = Thread.currentThread().getContextClassLoader();
		Thread.currentThread().setContextClassLoader(context);
		EbeanServer server = EbeanServerFactory.create(config);
		Thread.currentThread().setContextClassLoader(previousClassLoader);
		
		return server;
	}
	
	public static Collection<EbeanServer> create(Collection<ServerConfig> configs, ClassLoader context) {
		ImmutableList.Builder<EbeanServer> b  = ImmutableList.builder();
		
		ClassLoader previousClassLoader = Thread.currentThread().getContextClassLoader();
		Thread.currentThread().setContextClassLoader(context);
		synchronized (configs) {
			for (ServerConfig config : configs)
				b.add(EbeanServerFactory.create(config));
		}
		Thread.currentThread().setContextClassLoader(previousClassLoader);
		
		return b.build();
	}
	
	private EbeanServerUtils() { }
}
