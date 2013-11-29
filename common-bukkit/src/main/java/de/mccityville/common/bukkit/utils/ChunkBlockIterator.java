package de.mccityville.common.bukkit.utils;

import java.util.Iterator;

import org.bukkit.Chunk;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;

public class ChunkBlockIterator implements Iterator<Block> {
	
	private static final Vector INCREMENTOR_X = new Vector(1, 0, 0);
	private static final Vector INCREMENTOR_Y = new Vector(0, 1, 0);
	private static final Vector INCREMENTOR_Z = new Vector(0, 0, 1);
	private static final int CHUNK_HORIZONTALSIZE = 16;
	private static final int CHUNK_VERTICALSIZE = 256;
	
	private final Chunk chunk;
	private final boolean loadChunkIfUnloaded;
	private final Vector pointer = new Vector(0, 0, 0);
	
	public ChunkBlockIterator(Chunk chunk, boolean loadChunkIfUnloaded) {
		this.chunk = chunk;
		this.loadChunkIfUnloaded = loadChunkIfUnloaded;
	}

	public boolean hasNext() {
		return !(pointer.getBlockX() >= CHUNK_HORIZONTALSIZE - 1 &&
				pointer.getBlockY() >= CHUNK_VERTICALSIZE - 1 &&
				pointer.getBlockZ() >= CHUNK_HORIZONTALSIZE - 1);
	}
	
	public Block next() {
		if (loadChunkIfUnloaded && !chunk.isLoaded())
			chunk.load();
		
		Block block = chunk.getBlock(pointer.getBlockX(), pointer.getBlockY(), pointer.getBlockZ());
		
		incrementPointer();
		
		return block;
	}
	
	public void remove() {
		throw new UnsupportedOperationException("ChunkBlockIterator does not spport removal.");
	}
	
	private void incrementPointer() {
		if (pointer.getBlockX() < CHUNK_HORIZONTALSIZE - 1) {
			pointer.add(INCREMENTOR_X);
		} else {
			pointer.setX(0);
			if (pointer.getBlockZ() < CHUNK_HORIZONTALSIZE - 1) {
				pointer.add(INCREMENTOR_Z);
			} else {
				pointer.setZ(0);
				if (pointer.getBlockY() < CHUNK_VERTICALSIZE - 1) {
					pointer.add(INCREMENTOR_Y);
				}
			}
		}
	}
}
