package de.mccityville.common.java.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public class AssignedMethodInvoker {
	
	private final Object target;
	private final Method method;
	
	public AssignedMethodInvoker(Object target, Method method) {
		Preconditions.checkNotNull(method);
		
		this.target = target;
		this.method = method;
	}
	
	public Object getTarget() {
		return target;
	}
	
	public Method getMethod() {
		return method;
	}
	
	public Object invoke(Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (!method.isAccessible())
			method.setAccessible(true);
		
		return method.invoke(target, args);
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof AssignedMethodInvoker))
			return false;
		
		AssignedMethodInvoker invoker = (AssignedMethodInvoker) other;
		
		if (!Objects.equal(target, invoker.target))
			return false;
		
		if (!Objects.equal(method, invoker.method))
			return false;
		
		return true;
	}
}
