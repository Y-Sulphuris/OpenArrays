package com.ydo4ki.openarrays.ftable;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

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

}
