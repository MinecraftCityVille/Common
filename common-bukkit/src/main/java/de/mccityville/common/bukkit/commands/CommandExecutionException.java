package de.mccityville.common.bukkit.commands;

public class CommandExecutionException extends RuntimeException {
	
	private static final long serialVersionUID = 4374774310677573921L;
	
	public CommandExecutionException(String message) {
		super(message);
	}
	
	public CommandExecutionException(String message, Throwable cause) {
		super(message, cause);
	}
}
