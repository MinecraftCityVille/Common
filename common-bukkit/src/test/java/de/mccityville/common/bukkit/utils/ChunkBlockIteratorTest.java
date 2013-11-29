package de.mccityville.common.bukkit.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.bukkit.util.Vector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChunkBlockIteratorTest {
	
	private Method incrementor;
	private Field pointer;
	private ChunkBlockIterator iterator;
	
	@Before
	public void prepare() throws ReflectiveOperationException {
		incrementor = ChunkBlockIterator.class.getDeclaredMethod("incrementPointer");
		incrementor.setAccessible(true);
		pointer = ChunkBlockIterator.class.getDeclaredField("pointer");
		pointer.setAccessible(true);
		iterator = new ChunkBlockIterator(null, false);
	}
	
	@Test
	public void testIncrementation() throws ReflectiveOperationException {
		for (int i = 0; i < 16 * 16 * 256 - 1; i++)
			incrementor.invoke(iterator);
		
		Vector vec = (Vector) pointer.get(iterator);
		
		Assert.assertEquals(15, vec.getX(), 0);
		Assert.assertEquals(255, vec.getY(), 0);
		Assert.assertEquals(15, vec.getZ(), 0);
		Assert.assertFalse(iterator.hasNext());
	}
}
