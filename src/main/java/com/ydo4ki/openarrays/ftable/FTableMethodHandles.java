package com.ydo4ki.openarrays.ftable;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

class FTableMethodHandles<T> extends FTable<T> {
	private final MethodHandle[] indexGetters;
	private final MethodHandle[] indexSetters;

	FTableMethodHandles(MethodHandles.Lookup lookup, Class<?> owner, Class<T> fieldType, String... fieldNames) {
		indexGetters = new MethodHandle[fieldNames.length];
		indexSetters = new MethodHandle[fieldNames.length];
		for (int i = 0; i < fieldNames.length; i++) {
			try {
				indexGetters[i] = lookup.findGetter(owner, fieldNames[i], fieldType);
				indexSetters[i] = lookup.findSetter(owner, fieldNames[i], fieldType);
			} catch (NoSuchFieldException | IllegalAccessException e) {
				throw new FieldTableFormingException(e);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public T unsafeGet(Object owner, int index) throws Throwable {
		return (T) indexGetters[index].invoke(owner);
	}
	@SuppressWarnings("unchecked")
	public T unsafeGetExact(Object owner, int index) throws Throwable {
		return (T) indexGetters[index].invokeExact(owner);
	}

	public void unsafeSet(Object owner, int index, T newValue) throws Throwable {
		indexSetters[index].invoke(owner, newValue);
	}

	public void unsafeSetExact(Object owner, int index, T newValue) throws Throwable {
		indexSetters[index].invokeExact(owner, newValue);
	}
}
