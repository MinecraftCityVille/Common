package de.mccityville.common.java.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.google.common.base.Preconditions;

public class AssignedMethodInvoker {
	
	private final Object target;
	private final Method method;
	
	public AssignedMethodInvoker(Object target, Method method) {
		Preconditions.checkNotNull(method);
		
		this.target = target;
		this.method = method;
	}
	
	public Object invoke(Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return method.invoke(target, args);
	}
}
