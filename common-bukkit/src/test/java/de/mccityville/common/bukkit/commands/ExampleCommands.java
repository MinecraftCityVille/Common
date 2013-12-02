package de.mccityville.common.bukkit.commands;

import org.bukkit.command.CommandSender;

public class ExampleCommands {
	
	public static final int METHODS = 2;
	
	private boolean test1Executed = false;
	private static boolean test2Executed = false;
	
	@Command(name="test1")
	public void testCommand(CommandSender sender, String[] args) {
		test1Executed = true;
	}
	
	@Command(name="test2")
	public static void testStaticCommand(CommandSender sender, String[] args) {
		test2Executed = true;
	}
	
	public boolean isTest1Executed() {
		return test1Executed;
	}
	
	public static boolean isTest2Executed() {
		return test2Executed;
	}
}
