package com.ydo4ki.openarrays;

import com.ydo4ki.openarrays.arrays.*;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class OpenArrays {
	private OpenArrays() throws InstantiationException {
		throw new InstantiationException("Nope.");
	}

	public static final Object[] EMPTY_ARRAY = new Object[0];

	private static final Map<Integer, Class<? extends Array<?>>> arrayTypes = new HashMap<>();
	private static final Set<Integer> availableLen = new HashSet<>();
	static {
		for (int i = 0; i < 16; i++) {
			availableLen.add(i);
		}
		for (int i = 16; i < 128; i += 8) {
			availableLen.add(i);
		}
	}

	public static <T> Class<? extends Array<T>> arrayType(Class<T> elementType, final int length) {
		if (elementType.isPrimitive()) {
			throw new UnsupportedOperationException();
		}
		return objectArrayType(length);
	}
	@SuppressWarnings("unchecked")
	public static <T> Class<? extends Array<T>> objectArrayType(final int length) {
		if (availableLen.contains(length)) {
			Class<? extends Array<T>> type = (Class<? extends Array<T>>) arrayTypes.get(length);
			if (type == null) {
				try {
					type = (Class<? extends Array<T>>) Class.forName("com.ydo4ki.openarrays.arrays.Array" + length, false, ClassLoader.getSystemClassLoader());
					arrayTypes.put(length, type);
				} catch (ClassNotFoundException e) {
					throw new AssertionError(e);
				}
			}
			return type;
		}
		return (Class<? extends Array<T>>) (Object) Array.class;
	}

	public static <T> Array<T> newArray(int length) {
		Class<? extends Array<T>> type = objectArrayType(length);
		if ((type.getModifiers() & Modifier.ABSTRACT) != 0) {
			return Array.dynamic(length);
		}
		try {
			return type.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new AssertionError(e);
		}
	}

}
