package de.mccityville.common.bukkit.plugin;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class MCCVPlugin extends JavaPlugin {
	
	public void enable() { }
	
	public void disable() { }
	
	@Override
	public final void onEnable() {
		long enableStart = System.currentTimeMillis();
		
		getLogger().info(StringUtils.join("== Enable ", getName(), "... =="));
		enable();
		getLogger().info(StringUtils.join("== ", getName(), " enabled (took ", String.valueOf(System.currentTimeMillis() - enableStart), "ms) =="));
	}
	
	@Override
	public final void onDisable() {
		long disableStart = System.currentTimeMillis();
		
		getLogger().info(StringUtils.join("== Disable ", getName(), "... =="));
		disable();
		getLogger().info(StringUtils.join("== ", getName(), " disabled (took ", String.valueOf(System.currentTimeMillis() - disableStart), "ms) =="));
	}
}
