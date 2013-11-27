package de.mccityville.common.bukkit;

import de.mccityville.common.bukkit.plugin.MCCVPlugin;

public class CommonPlugin extends MCCVPlugin {
	
	private static volatile CommonPlugin instance;
	
	@Override
	public void enable() {
		instance = this;
	}
	
	public static CommonPlugin instance() {
		if (instance == null)
			throw new IllegalStateException("Common plugin seems to be uninitialized.");
		
		return instance;
	}
}
