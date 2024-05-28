package com.ydo4ki.openarrays.ftable;

public abstract class FTable<T> {
	public abstract T unsafeGet(Object owner, int index) throws Throwable;

	public abstract T unsafeGetExact(Object owner, int index) throws Throwable;

	public abstract void unsafeSet(Object owner, int index, T newValue) throws Throwable;

	public abstract void unsafeSetExact(Object owner, int index, T newValue) throws Throwable;
}
