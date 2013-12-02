package de.mccityville.common.bukkit.utils;

import org.junit.Assert;
import org.junit.Test;

public class PlayerUtilsTest {
	
	@Test
	public void testPlayernameValidator() {
		String[] validNames = new String[] {
				"md_5",
				"MonsieurApple",
				"b0xx3r"
		};
		String[] invalidNames = new String[] {
				"ThisNameIsLongerThan16Characters",
				""
		};
		
		for (String name : validNames)
			Assert.assertTrue(PlayerUtils.isValidPlayername(name));
		
		for (String name : invalidNames)
			Assert.assertFalse(PlayerUtils.isValidPlayername(name));
	}
}
