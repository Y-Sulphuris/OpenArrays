package com.ydo4ki.openarrays.ftable;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;

public interface FTable<O, T> {
	public abstract T unsafeGet(O owner, int index) throws Throwable;

	public abstract T unsafeGetExact(O owner, int index) throws Throwable;

	public abstract void unsafeSet(O owner, int index, T newValue) throws Throwable;

	public abstract void unsafeSetExact(O owner, int index, T newValue) throws Throwable;

	public abstract int size();

	@SuppressWarnings("unchecked")
    public default T[] toArray(O owner) throws Throwable {
		int len = size();
		T[] array = (T[]) new Object[len];
		for (int i = 0; i < len; i++) {
			array[i] = unsafeGet(owner, i);
		}
		return array;
	}

	static <O, T> FTable<O, T> fast(MethodHandles.Lookup lookup, Class<O> owner, Class<T> fieldType, String fieldNamesBase, int length) throws FieldTableFormingException {
		String[] names = new String[length];
		for (int i = 0; i < length; i++) {
			names[i] = fieldNamesBase + i;
		}
		return fast(lookup, owner, fieldType, names);
	}

	static <T> FTable<?, T> fast(MethodHandles.Lookup lookup, Class<T> fieldType, String classesNameFormat, String fieldNameFormat, int length) throws FieldTableFormingException {
		String[] names = new String[length];
		Class<?>[] classes = new Class[length];
		for (int i = 0; i < length; i++) {
			names[i] = String.format(fieldNameFormat, i);
            try {
                classes[i] = Class.forName(String.format(classesNameFormat, i));
            } catch (ClassNotFoundException e) {
                throw new FieldTableFormingException(e);
            }
        }
		return fast(lookup, classes, fieldType, names);
	}

	static <O, T> FTable<O, T> fast(MethodHandles.Lookup lookup, Class<?>[] owners, Class<T> fieldType, String... fieldNames) throws FieldTableFormingException {
		if (FTableUnsafe.isAllowed) try {
			int len = fieldNames.length;
			Field[] fields = new Field[len];
			for (int i = 0; i < len; i++) {
				fields[i] = owners[i].getDeclaredField(fieldNames[i]);
			}
			return new FTableUnsafeObject<>(owners, fieldType, fields);
		} catch (FieldTableFormingException e) {
			throw e;
		} catch (Exception e) {
			throw new FieldTableFormingException(e);
		}
		return methodHandle(lookup, owners, fieldType, fieldNames);
	}
	static <O, T> FTable<O, T> fast(MethodHandles.Lookup lookup, Class<O> owner, Class<T> fieldType, String... fieldNames) throws FieldTableFormingException {
		if (FTableUnsafe.isAllowed) try {
			int len = fieldNames.length;
			Field[] fields = new Field[len];
			for (int i = 0; i < len; i++) {
				fields[i] = owner.getDeclaredField(fieldNames[i]);
			}
			return new FTableUnsafeObject<>(owner, fieldType, fields);
		} catch (FieldTableFormingException e) {
			throw e;
		} catch (Exception e) {
            throw new FieldTableFormingException(e);
        }
        return methodHandle(lookup, owner, fieldType, fieldNames);
	}

	static <O, T> FTable<O, T> methodHandle(MethodHandles.Lookup lookup, Class<O> owner, Class<T> fieldType, String... fieldNames) throws FieldTableFormingException {
		return new FTableMethodHandlesObject<>(lookup, owner, fieldType, fieldNames);
	}
	static <O, T> FTable<O, T> methodHandle(MethodHandles.Lookup lookup, Class<?>[] owners, Class<T> fieldType, String... fieldNames) throws FieldTableFormingException {
		return new FTableMethodHandlesObject<>(lookup, owners, fieldType, fieldNames);
	}
}
