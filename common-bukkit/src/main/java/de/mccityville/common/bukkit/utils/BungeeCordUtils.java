package de.mccityville.common.bukkit.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.mccityville.common.bukkit.CommonPlugin;

public final class BungeeCordUtils {
	
	public static final String BUNGEE_CHANNEL = "BungeeCord";
	
	static {
		Bukkit.getMessenger().registerOutgoingPluginChannel(CommonPlugin.instance(), BUNGEE_CHANNEL);
	}
	
	public static void sendToServer(Player player, String serverName) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		
		try {
			out.writeUTF("Connect");
			out.writeUTF(serverName);
		} catch (IOException e) {
			Bukkit.getLogger().log(Level.SEVERE, "Failed to communicate with BungeeCord: " + e.getMessage(), e);
		}
		
		player.sendPluginMessage(CommonPlugin.instance(), BUNGEE_CHANNEL, b.toByteArray());
	}
	
	private BungeeCordUtils() { }
}
