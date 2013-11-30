package de.mccityville.common.bukkit;

import de.mccityville.common.bukkit.plugin.MCCVPlugin;

public class CommonPlugin extends MCCVPlugin {
	
	private static volatile CommonPlugin instance;
	
	private CommonPluginConfiguration config;
	
	@Override
	public void enable() {
		config = (CommonPluginConfiguration) getConfig().get("common-configuration");
		if (config == null) {
			config = new CommonPluginConfiguration();
			getConfig().set("common-configuration", config);
			saveConfig();
		}
		
		instance = this;
	}
	
	public CommonPluginConfiguration getCommonConfiguration() {
		return config;
	}
	
	public static CommonPlugin instance() {
		if (instance == null)
			throw new IllegalStateException("Common plugin seems to be uninitialized.");
		
		return instance;
	}
}
