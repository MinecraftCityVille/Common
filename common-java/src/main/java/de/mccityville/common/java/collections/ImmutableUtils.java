package de.mccityville.common.java.collections;

import java.util.Collection;
import java.util.Map;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

public final class ImmutableUtils {
	
	public static <T> ImmutableList<T> immutableList(Collection<T> collection) {
		ImmutableList.Builder<T> builder = ImmutableList.builder();
		
		synchronized (collection) {
			if (collection.size() > 0)
				builder.addAll(collection);
		}
		
		return builder.build();
	}
	
	public static <T> ImmutableSet<T> immutableSet(Collection<T> collection) {
		ImmutableSet.Builder<T> builder = ImmutableSet.builder();

		synchronized (collection) {
			if (collection.size() > 0)
			builder.addAll(collection);
		}
		
		return builder.build();
	}
	
	public static <K, V> ImmutableMap<K, V> immutableMap(Map<K, V> map) {
		ImmutableMap.Builder<K, V> builder = ImmutableMap.builder();
		
		synchronized (map) {
			if (map.size() > 0)
				builder.putAll(map);
		}
		
		return builder.build();
	}
	
	public static <K, V> ImmutableBiMap<K, V> immutableBiMap(Map<K, V> map) {
		ImmutableBiMap.Builder<K, V> builder = ImmutableBiMap.builder();
		
		synchronized (map) {
			if (map.size() > 0)
				builder.putAll(map);
		}
		
		return builder.build();
	}
	
	private ImmutableUtils() { }
}
