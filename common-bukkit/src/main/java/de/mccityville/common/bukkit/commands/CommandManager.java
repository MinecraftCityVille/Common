package de.mccityville.common.bukkit.commands;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.bukkit.command.CommandSender;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import de.mccityville.common.bukkit.utils.TextUtils;
import de.mccityville.common.java.ErrorHandler;
import de.mccityville.common.java.StringUtils;
import de.mccityville.common.java.collections.ImmutableUtils;
import de.mccityville.common.java.reflection.AssignedMethodInvoker;

public class CommandManager {
	
	private final Set<CommandRegistration> commands = Sets.newHashSet();
	private final ErrorHandler handler;
	
	public CommandManager(ErrorHandler handler) {
		this.handler = handler;
	}
	
	@SuppressWarnings("unchecked")
	public <T> ImmutableSet<CommandRegistration> registerCommands(T instance) {
		return registerCommands((Class<T>) instance.getClass(), instance);
	}
	
	public <T> ImmutableSet<CommandRegistration> registerCommands(Class<T> clazz, T instance) {
		List<CommandRegistration> commands = Lists.newArrayList();
		
		for (Method method : clazz.getDeclaredMethods()) {
			Command command = method.getAnnotation(Command.class);
			
			if (command == null)
				continue;
			
			AssignedMethodInvoker invoker = null;
			if (Modifier.isStatic(method.getModifiers()))
				invoker = new AssignedMethodInvoker(null, method);
			else
				invoker = new AssignedMethodInvoker(instance, method);
			
			CommandRegistration registration = new CommandRegistration(invoker, command);
			
			commands.add(registration);
		}
		
		Iterator<CommandRegistration> regs = commands.iterator();
		while (regs.hasNext())
			if (!this.commands.add(regs.next()))
				regs.remove();
		
		return ImmutableUtils.immutableSet(commands);
	}
	
	public void addRegistration(CommandRegistration registration) {
		synchronized (commands) {
			commands.add(registration);
		}
	}
	
	public ImmutableSet<CommandRegistration> getRegistrations() {
		return ImmutableUtils.immutableSet(commands);
	}
	
	public CommandRegistration getRegistration(String labelOrAlias) {
		synchronized (commands) {
			for (CommandRegistration registration : commands) {
				if (registration.getCommand().name().equalsIgnoreCase(labelOrAlias))
					return registration;
				
				if (StringUtils.containsCaseInsensitive(registration.getCommand().aliases(), labelOrAlias))
					return registration;
			}
		}
		
		return null;
	}
	
	public void invoke(CommandSender sender, String label, String[] args) {
		CommandRegistration command = getRegistration(label);
		
		if (command == null) {
			sender.sendMessage(TextUtils.format("<red>Command not found: %s", label));
			return;
		}
		
		List<Object> arguments = Lists.newArrayList();
		for (Class<?> clazz : command.getMethod().getMethod().getParameterTypes())
			arguments.add(map(clazz, sender, label, args));
		
		try {
			command.getMethod().invoke(arguments.toArray());
		} catch (ReflectiveOperationException e) {
			if (e.getCause() instanceof CommandExecutionException) {
				sender.sendMessage(e.getMessage());
				return;
			} else
				handler.handleThrowable(e);
		}
	}
	
	private Object map(Class<?> clazz, CommandSender sender, String label, String[] args) {
		if (clazz.equals(CommandSender.class))
			return sender;
		else if (clazz.equals(String[].class))
			return args;
		
		throw new CommandExecutionException("Unmapped argument class: " + clazz);
	}
}
