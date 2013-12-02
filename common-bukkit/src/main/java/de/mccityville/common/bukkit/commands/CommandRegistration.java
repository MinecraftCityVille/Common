package de.mccityville.common.bukkit.commands;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import de.mccityville.common.java.reflection.AssignedMethodInvoker;

public class CommandRegistration {
	
	private final AssignedMethodInvoker method;
	private final Command command;
	
	CommandRegistration(AssignedMethodInvoker method, Command command) {
		this.method = method;
		this.command = command;
	}
	
	public AssignedMethodInvoker getMethod() {
		return method;
	}
	
	public Command getCommand() {
		return command;
	}
	
	@Override
	public int hashCode() {
		HashCodeBuilder hash = new HashCodeBuilder();
		
		hash.append(method);
		hash.append(command);
		
		return hash.toHashCode();
	}
}
