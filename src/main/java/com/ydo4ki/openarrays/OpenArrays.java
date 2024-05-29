package com.ydo4ki.openarrays;

import com.ydo4ki.openarrays.arrays.*;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("rawtypes")
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
		return objectArrayType(elementType, length);
	}
	@SuppressWarnings("unchecked")
	public static <T> Class<? extends Array<T>> objectArrayType(Class<T> elementType, final int length) {
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

	@SuppressWarnings("unchecked")
	public static <T> Class<? extends Array<T>> objectArrayType(Class<T> elementType, Class<? extends Array> baseArrayType) {
		if (elementType == Object.class)
			return (Class<? extends Array<T>>) baseArrayType;
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unchecked")
	public static <T> Array<T> newArray(int length) {
		return (Array<T>) newArray(Object.class, length);
	}
	public static <T> Array<T> newArray(Class<T> elementType, int length) {
		Class<? extends Array<T>> baseType = objectArrayType(elementType, length);
		if ((baseType.getModifiers() & Modifier.ABSTRACT) != 0) {
			return Array.dynamic(length);
		}
		return newArray(elementType, baseType);
	}
	public static <T> Array<T> newArray(Class<T> elementType, Class<? extends Array> baseArrayType) {
		Class<? extends Array<T>> type = objectArrayType(elementType, baseArrayType);

		try {
			return type.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new AssertionError(e);
		}
	}
}
