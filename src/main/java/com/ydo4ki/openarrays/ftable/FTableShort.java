package com.ydo4ki.openarrays.ftable;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;

public interface FTableShort<O> {
    short unsafeGet(O owner, int index) throws Throwable;

    short unsafeGetExact(O owner, int index) throws Throwable;

    void unsafeSet(O owner, int index, short newValue) throws Throwable;

    void unsafeSetExact(O owner, int index, short newValue) throws Throwable;

	static <O> FTableShort<O> fast(MethodHandles.Lookup lookup, Class<O> owner, String fieldNamesBase, int length) throws FieldTableFormingException {
		String[] names = new String[length];
		for (int i = 0; i < length; i++) {
			names[i] = fieldNamesBase + i;
		}
		return fast(lookup, owner, names);
	}

	static <O> FTableShort<O> fast(MethodHandles.Lookup lookup, Class<O> owner, String... fieldNames) throws FieldTableFormingException {
		if (FTableUnsafe.isAllowed) try {
			int len = fieldNames.length;
			Field[] fields = new Field[len];
			for (int i = 0; i < len; i++) {
				fields[i] = owner.getDeclaredField(fieldNames[i]);
			}
			return new FTableUnsafeShort<>(owner, fields);
		} catch (FieldTableFormingException e) {
			throw e;
		} catch (Exception e) {
			throw new FieldTableFormingException(e);
		}
		return new FTableMethodHandlesShort<>(lookup, owner, fieldNames);
	}

	static <O> FTableShort<O> fast(MethodHandles.Lookup lookup, Field[] fields) throws FieldTableFormingException {
		if (FTableUnsafe.isAllowed) try {
			return new FTableUnsafeShort<>(fields);
		} catch (FieldTableFormingException e) {
			throw e;
		} catch (Exception e) {
			throw new FieldTableFormingException(e);
		}
		return methodHandle(lookup, fields);
	}

	static <O> FTableShort<O> methodHandle(MethodHandles.Lookup lookup, Class<O> owner, String... fieldNames) throws FieldTableFormingException {
		return new FTableMethodHandlesShort<>(lookup, owner, fieldNames);
	}
	static <O> FTableShort<O> methodHandle(MethodHandles.Lookup lookup, Field[] fields) throws FieldTableFormingException {
		return new FTableMethodHandlesShort<>(lookup, fields);
	}
}
