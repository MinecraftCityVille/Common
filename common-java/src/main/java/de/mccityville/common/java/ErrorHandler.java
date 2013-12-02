package de.mccityville.common.java;

public interface ErrorHandler {
	
	<T extends Throwable> void handleThrowable(T thrown);
}
