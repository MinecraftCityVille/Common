package de.mccityville.common.bukkit.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;

import de.mccityville.common.bukkit.utils.config.ConfigurationCaster;

public class ConfigurationCasterTest {
	
	private ImmutableMap<String, Object> testData = new ImmutableMap.Builder<String, Object>()
			.put("testString", "TEST")
			.put("testInteger", new Integer(42))
			.put("testDouble", new Double(42.24))
			.put("testBoolean", new Boolean(true))
			.build();
	private ConfigurationCaster caster;
	
	@Before
	public void prepare() {
		caster = new ConfigurationCaster(testData);
	}
	
	@Test
	public void testStringCast() {
		Assert.assertEquals(testData.get("testString"), caster.getString("testString"));
		Assert.assertEquals("asdf", caster.getString("UNKNOWN", "asdf"));
	}
	
	@Test
	public void testIntegerCast() {
		Assert.assertEquals((Integer) testData.get("testInteger"), caster.getInteger("testInteger"));
		Assert.assertEquals((Integer) 42, caster.getInteger("UNKNOWN", 42));
	}
	
	@Test
	public void testDoubleCast() {
		Assert.assertEquals((Double) testData.get("testDouble"), caster.getDouble("testDouble"));
		Assert.assertEquals((Double) 42.24, caster.getDouble("UNKNOWN", 42.24));
	}
	
	@Test
	public void testBoolean() {
		Assert.assertTrue(caster.getBoolean("testBoolean"));
		Assert.assertTrue(caster.getBoolean("UNKNOWN", true));
	}
}
