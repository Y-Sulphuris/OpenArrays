package com.ydo4ki.openarrays.ftable;


import java.lang.reflect.Field;

class FTableUnsafe<O> {

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

	FTableUnsafe(Class<? extends O> owner, Class<?> fieldType, Field[] fields) {
		fieldOffsets = new long[fields.length];
		for (int i = 0; i < fields.length; i++) {
			if (!fields[i].getDeclaringClass().isAssignableFrom(owner))
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

	FTableUnsafe(Field[] fields) {
		this(fields[0].getType(), fields);
	}
	FTableUnsafe(Class<?> fieldType, Field[] fields) {
		fieldOffsets = new long[fields.length];
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getType() != fieldType)
				throw new IllegalArgumentException("Incorrect field type " + fields[i] + "(" + fieldType.getCanonicalName() + " expected)");
			try {
				assert U != null;
				fieldOffsets[i] = ((sun.misc.Unsafe)U).objectFieldOffset(fields[i]);
			} catch (Throwable e) {
				isAllowed = true;
				throw e;
			}
		}
	}

}
