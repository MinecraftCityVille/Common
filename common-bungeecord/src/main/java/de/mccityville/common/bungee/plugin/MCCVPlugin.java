package de.mccityville.common.bungee.plugin;

import org.apache.commons.lang3.StringUtils;

import net.md_5.bungee.api.plugin.Plugin;

public abstract class MCCVPlugin extends Plugin {
	
	public void enable() { }
	
	public void disable() { }
	
	@Override
	public final void onEnable() {
		long enableStart = System.currentTimeMillis();
		
		getLogger().info(StringUtils.join("== Enable ", getDescription().getName(), "... =="));
		enable();
		getLogger().info(StringUtils.join("== ", getDescription().getName(), " enabled (took ", String.valueOf(System.currentTimeMillis() - enableStart), "ms) =="));
	}
	
	@Override
	public final void onDisable() {
long disableStart = System.currentTimeMillis();
		
		getLogger().info(StringUtils.join("== Disable ", getDescription().getName(), "... =="));
		disable();
		getLogger().info(StringUtils.join("== ", getDescription().getName(), " disabled (took ", String.valueOf(System.currentTimeMillis() - disableStart), "ms) =="));
	}
}
