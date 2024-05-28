package com.ydo4ki.openarrays.ftable;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;

public interface FTable<O, T> {
	public abstract T unsafeGet(O owner, int index) throws Throwable;

	public abstract T unsafeGetExact(O owner, int index) throws Throwable;

	public abstract void unsafeSet(O owner, int index, T newValue) throws Throwable;

	public abstract void unsafeSetExact(O owner, int index, T newValue) throws Throwable;


	static <O, T> FTable<O, T> newTable(MethodHandles.Lookup lookup, Class<O> owner,  Class<T> fieldType, String fieldNamesBase, int length) throws FieldTableFormingException {
		String[] names = new String[length];
		for (int i = 0; i < length; i++) {
			names[i] = fieldNamesBase + i;
		}
		return newTable(lookup, owner, fieldType, names);
	}

	static <O, T> FTable<O, T> newTable(MethodHandles.Lookup lookup, Class<O> owner, Class<T> fieldType, String... fieldNames) throws FieldTableFormingException {
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
        return new FTableMethodHandlesObject<>(lookup, owner, fieldType, fieldNames);
	}
}
