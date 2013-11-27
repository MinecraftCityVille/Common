package de.mccityville.common.java.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SafeFuture<T> implements Future<T> {
	
	private final Future<T> future;
	private Exception e;
	
	public SafeFuture(Future<T> future) {
		this.future = future;
	}
	
	public boolean cancel(boolean mayInterruptIfRunning) {
		return future.cancel(mayInterruptIfRunning);
	}
	
	public boolean isCancelled() {
		return future.isCancelled();
	}
	
	public boolean isDone() {
		return future.isDone();
	}
	
	public T get() throws InterruptedException, ExecutionException {
		return future.get();
	}
	
	public T getSafe() {
		try {
			return get();
		} catch (Exception e) {
			this.e = e;
			return null;
		}
	}
	
	public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
		return future.get(timeout, unit);
	}
	
	public T getSafe(long timeout, TimeUnit unit) {
		try {
			return get(timeout, unit);
		} catch (Exception e) {
			this.e = e;
			return null;
		}
	}
	
	public Exception getException() {
		return e;
	}
}
