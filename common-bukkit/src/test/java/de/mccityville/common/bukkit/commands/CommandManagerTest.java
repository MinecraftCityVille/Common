package de.mccityville.common.bukkit.commands;

import org.junit.Assert;
import org.junit.Test;

import de.mccityville.common.java.ErrorHandler;

public class CommandManagerTest {
	
	private final CommandManager manager = new CommandManager(new ErrorHandler() {
		public <T extends Throwable> void handleThrowable(T thrown) {
			Assert.fail();
		}
	});
	
	@Test
	public void testCommandLifecycle() {
		ExampleCommands commands = new ExampleCommands();
		Assert.assertEquals(ExampleCommands.METHODS, manager.registerCommands(commands).size());
		
		manager.invoke(null, "test1", new String[0]);
		manager.invoke(null, "test2", new String[0]);
		
		Assert.assertTrue(commands.isTest1Executed());
		Assert.assertTrue(ExampleCommands.isTest2Executed());
	}
}
