package com.ydo4ki.openarrays.ftable;

import java.lang.reflect.Field;

public class FTableUnsafeObject<O, T> extends FTableUnsafe<O> implements FTable<O,T>  {

	FTableUnsafeObject(Class<O> owner, Class<T> fieldType, Field[] fields) {
		super(owner, fieldType, fields);
	}
	FTableUnsafeObject(Class<?>[] owners, Class<T> fieldType, Field[] fields) {
		super(owners, fieldType, fields);
	}

	@Override
	public int size() {
		return fieldOffsets.length;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T unsafeGet(O owner, int index) throws Throwable {
		assert U != null;
		return (T) ((sun.misc.Unsafe)U).getObject(owner, fieldOffsets[index]);
	}

	@Override
	public T unsafeGetExact(O owner, int index) throws Throwable {
		return unsafeGet(owner, index);
	}


	@Override
	public void unsafeSet(O owner, int index, T newValue) throws Throwable {
		assert U != null;
		((sun.misc.Unsafe)U).putObject(owner, fieldOffsets[index], newValue);
	}

	@Override
	public void unsafeSetExact(O owner, int index, T newValue) throws Throwable {
		unsafeSet(owner, index, newValue);
	}
}
