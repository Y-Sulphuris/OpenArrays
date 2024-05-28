package com.ydo4ki.openarrays.ftable;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;

class FTableMethodHandlesChar<O> extends FTableMethodHandles<O> implements FTableChar<O> {
    FTableMethodHandlesChar(MethodHandles.Lookup lookup, Class<O> owner, String... fieldNames) {
        super(lookup, owner, char.class, fieldNames);
    }

	FTableMethodHandlesChar(MethodHandles.Lookup lookup, Field[] fields) {
		super(lookup, char.class, fields);
	}

	public char unsafeGet(O owner, int index) throws Throwable {
        return (char) indexGetters[index].invoke(owner);
    }
    public char unsafeGetExact(O owner, int index) throws Throwable {
        return (char) indexGetters[index].invokeExact(owner);
    }

    public void unsafeSet(O owner, int index, char newValue) throws Throwable {
        indexSetters[index].invoke(owner, newValue);
    }

    public void unsafeSetExact(O owner, int index, char newValue) throws Throwable {
        indexSetters[index].invokeExact(owner, newValue);
    }
}
