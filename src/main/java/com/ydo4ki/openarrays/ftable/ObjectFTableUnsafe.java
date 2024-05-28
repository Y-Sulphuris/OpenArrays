package com.ydo4ki.openarrays.ftable;

import java.lang.reflect.Field;

public class ObjectFTableUnsafe<T> extends FTableUnsafe<T> {


	ObjectFTableUnsafe(Class<?> owner, Class<?> fieldType, Field[] fields) {
		super(owner, fieldType, fields);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T unsafeGet(Object owner, int index) throws Throwable {
		assert U != null;
		return (T) ((sun.misc.Unsafe)U).getObject(owner, fieldOffsets[index]);
	}

	@Override
	public void unsafeSet(Object owner, int index, T newValue) throws Throwable {
		assert U != null;
		((sun.misc.Unsafe)U).putObject(owner, fieldOffsets[index], newValue);
	}
}
