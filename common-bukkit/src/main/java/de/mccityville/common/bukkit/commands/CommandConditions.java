package de.mccityville.common.bukkit.commands;

import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public final class CommandConditions {
	
	public static void isPlayer(CommandSender sender) {
		if (!(sender instanceof Player))
			throw new CommandExecutionException("This command must be sent as a player.");
	}
	
	public static void isCommandBlock(CommandSender sender) {
		if (!(sender instanceof BlockCommandSender))
			throw new CommandExecutionException("This command must be sent as a BlockCommandSender.");
	}
	
	public static void isConsole(CommandSender sender) {
		if (!(sender instanceof ConsoleCommandSender))
			throw new CommandExecutionException("This command must be sent from Console.");
	}
	
	private CommandConditions() { }
}
