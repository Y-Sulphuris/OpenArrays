package com.ydo4ki.openarrays.ftable;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;

class FTableMethodHandles<O> {
	final MethodHandle[] indexGetters;
	final MethodHandle[] indexSetters;

	FTableMethodHandles(MethodHandles.Lookup lookup, Class<O> owner, Class<?> fieldType, String[] fieldNames) {
		indexGetters = new MethodHandle[fieldNames.length];
		indexSetters = new MethodHandle[fieldNames.length];
		for (int i = 0; i < fieldNames.length; i++) {
			try {
				indexGetters[i] = lookup.findGetter(owner, fieldNames[i], fieldType);
				indexSetters[i] = lookup.findSetter(owner, fieldNames[i], fieldType);
			} catch (NoSuchFieldException | IllegalAccessException e) {
				throw new FieldTableFormingException(e);
			}
		}
	}

	FTableMethodHandles(MethodHandles.Lookup lookup, Class<?>[] owner, Class<?> fieldType, String[] fieldNames) {
		indexGetters = new MethodHandle[fieldNames.length];
		indexSetters = new MethodHandle[fieldNames.length];
		for (int i = 0; i < fieldNames.length; i++) {
			try {
				indexGetters[i] = lookup.findGetter(owner[i], fieldNames[i], fieldType);
				indexSetters[i] = lookup.findSetter(owner[i], fieldNames[i], fieldType);
			} catch (NoSuchFieldException | IllegalAccessException e) {
				throw new FieldTableFormingException(e);
			}
		}
	}

	FTableMethodHandles(MethodHandles.Lookup lookup, Class<?> fieldType, Field[] fields) {
		indexGetters = new MethodHandle[fields.length];
		indexSetters = new MethodHandle[fields.length];
		for (int i = 0; i < fields.length; i++) {
			try {
				if (fields[i].getType() != fieldType)
					throw new IllegalArgumentException("Incorrect field type " + fields[i] + "(" + fieldType.getCanonicalName() + " expected)");
				indexGetters[i] = lookup.unreflectGetter(fields[i]);
				indexSetters[i] = lookup.unreflectGetter(fields[i]);
			} catch (IllegalAccessException e) {
				throw new FieldTableFormingException(e);
			}
		}
	}
	FTableMethodHandles(MethodHandles.Lookup lookup, Field[] fields) {
		indexGetters = new MethodHandle[fields.length];
		indexSetters = new MethodHandle[fields.length];
		for (int i = 0; i < fields.length; i++) {
			try {
				indexGetters[i] = lookup.unreflectGetter(fields[i]);
				indexSetters[i] = lookup.unreflectGetter(fields[i]);
			} catch (IllegalAccessException e) {
				throw new FieldTableFormingException(e);
			}
		}
	}

}
