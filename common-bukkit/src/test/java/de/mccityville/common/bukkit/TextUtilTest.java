package de.mccityville.common.bukkit;

import org.bukkit.ChatColor;
import org.junit.Assert;
import org.junit.Test;

import de.mccityville.common.bukkit.utils.TextUtils;

public class TextUtilTest {
	
	@Test
	public void testReplacements() {
		String test = "Test";
		
		Assert.assertEquals(ChatColor.GREEN + test, TextUtils.format("<green>" + test));
	}
}
