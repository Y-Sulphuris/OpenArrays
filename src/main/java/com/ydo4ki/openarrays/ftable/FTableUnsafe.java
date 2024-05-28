package com.ydo4ki.openarrays.ftable;


import java.lang.reflect.Field;

abstract class FTableUnsafe<T> extends FTable<T> {

	static boolean isAllowed;

	static final Object U = getU();

	private static Object getU() {
		try {
			isAllowed = true;
			Field f = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			return f.get(null);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			isAllowed = false;
			return null;
		}
	}

	final long[] fieldOffsets;
	final Class<?> owner;

	FTableUnsafe(Class<?> owner, Class<?> fieldType, Field[] fields) {
		fieldOffsets = new long[fields.length];
		this.owner = owner;
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getDeclaringClass() != owner)
				throw new IllegalArgumentException("Incorrect owner type " + fields[i]);
			if (fields[i].getType() != fieldType)
				throw new IllegalArgumentException("Incorrect field type " + fields[i]);
			try {
				assert U != null;
				fieldOffsets[i] = ((sun.misc.Unsafe)U).objectFieldOffset(fields[i]);
			} catch (Throwable e) {
				isAllowed = true;
				throw e;
			}
		}
	}


	@Override
	public T unsafeGetExact(Object owner, int index) throws Throwable {
		return unsafeGet(owner, index);
	}

	@Override
	public void unsafeSetExact(Object owner, int index, T newValue) throws Throwable {
		unsafeSet(owner, index, newValue);
	}
}