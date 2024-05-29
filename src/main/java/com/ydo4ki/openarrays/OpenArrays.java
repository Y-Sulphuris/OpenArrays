package com.ydo4ki.openarrays;

import com.ydo4ki.openarrays.arrays.*;

import java.lang.reflect.Modifier;
import java.util.*;

@SuppressWarnings({"rawtypes", "unchecked"})
public final class OpenArrays {
	private OpenArrays() throws InstantiationException {
		throw new InstantiationException("Nope.");
	}

	public static final Object[] EMPTY_ARRAY = new Object[0];

	private static final Map<Integer, Class<? extends OpenArray<?>>> arrayTypes = new HashMap<>();
	private static final Set<Integer> availableLen = new HashSet<>();
	static {
		for (int i = 0; i < 16; i++) {
			availableLen.add(i);
		}
		for (int i = 16; i < 128; i += 8) {
			availableLen.add(i);
		}
	}

	public static <T> Class<? extends OpenArray<T>> arrayType(Class<T> elementType, final int length) {
		if (elementType.isPrimitive()) {
			throw new UnsupportedOperationException();
		}
		return objectArrayType(elementType, length);
	}
	public static <T> Class<? extends OpenArray<T>> objectArrayType(Class<T> elementType, final int length) {
		if (availableLen.contains(length)) {
			Class<? extends OpenArray<T>> type = (Class<? extends OpenArray<T>>) arrayTypes.get(length);
			if (type == null) {
				try {
					type = (Class<? extends OpenArray<T>>) Class.forName("com.ydo4ki.openarrays.arrays.Array" + length, false, ClassLoader.getSystemClassLoader());
					arrayTypes.put(length, type);
				} catch (ClassNotFoundException e) {
					throw new AssertionError(e);
				}
			}
			return type;
		}
		return (Class<? extends OpenArray<T>>) (Object) OpenArray.class;
	}

	public static <T> Class<? extends OpenArray<T>> objectArrayType(Class<T> elementType, Class<? extends OpenArray> baseArrayType) {
		if (elementType == Object.class)
			return (Class<? extends OpenArray<T>>) baseArrayType;
		throw new UnsupportedOperationException();
	}

	public static <T> OpenArray<T> newArray(int length) {
		return (OpenArray<T>) newArray(Object.class, length);
	}
	public static <T> OpenArray<T> newArray(Class<T> elementType, int length) {
		Class<? extends OpenArray<T>> baseType = objectArrayType(elementType, length);
		if ((baseType.getModifiers() & Modifier.ABSTRACT) != 0) {
			return OpenArray.dynamic(length);
		}
		return newArray(elementType, baseType);
	}
	public static <T> OpenArray<T> newArray(Class<T> elementType, Class<? extends OpenArray> baseArrayType) {
		Class<? extends OpenArray<T>> type = objectArrayType(elementType, baseArrayType);

		try {
			return type.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new AssertionError(e);
		}
	}





	public static Object get(Object array, int index) {
		Objects.requireNonNull(array);
		if (array instanceof AnyOpenArray) return AnyOpenArray.get((AnyOpenArray)array, index);
		if (array.getClass().isArray()) return java.lang.reflect.Array.get(array, index);
		if (array instanceof Array) return ((Array) array).get(index);
		if (array instanceof BooleanArray) return ((BooleanArray) array).get(index);
		if (array instanceof ByteArray) return ((ByteArray) array).get(index);
		if (array instanceof ShortArray) return ((ShortArray) array).get(index);
		if (array instanceof CharArray) return ((CharArray) array).get(index);
		if (array instanceof IntArray) return ((IntArray) array).get(index);
		if (array instanceof FloatArray) return ((FloatArray) array).get(index);
		if (array instanceof LongArray) return ((LongArray) array).get(index);
		if (array instanceof DoubleArray) return ((DoubleArray) array).get(index);
		return java.lang.reflect.Array.get(array, index); // throw an exception
	}
	public static void set(Object array, int index, Object newValue) {
		Objects.requireNonNull(array);
		if (array instanceof AnyOpenArray) AnyOpenArray.set((AnyOpenArray)array, index, newValue);
		else if (array.getClass().isArray()) java.lang.reflect.Array.set(array, index, newValue);
		else if (array instanceof Array) ((Array) array).set(index, newValue);
		else if (array instanceof BooleanArray) ((BooleanArray) array).set(index, (Boolean)newValue);
		else if (array instanceof ByteArray) ((ByteArray) array).set(index, (Byte)newValue);
		else if (array instanceof ShortArray) ((ShortArray) array).set(index, (Short)newValue);
		else if (array instanceof CharArray) ((CharArray) array).set(index, (Character) newValue);
		else if (array instanceof IntArray) ((IntArray) array).set(index, (Integer)newValue);
		else if (array instanceof FloatArray) ((FloatArray) array).set(index, (Float)newValue);
		else if (array instanceof LongArray) ((LongArray) array).set(index, (Long)newValue);
		else if (array instanceof DoubleArray) ((DoubleArray) array).set(index, (Double)newValue);
		java.lang.reflect.Array.set(array, index, newValue); // throw an exception
	}
}
