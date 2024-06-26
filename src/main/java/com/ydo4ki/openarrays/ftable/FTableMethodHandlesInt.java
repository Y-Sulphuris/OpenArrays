package com.ydo4ki.openarrays.ftable;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;

class FTableMethodHandlesInt<O> extends FTableMethodHandles<O> implements FTableInt<O> {
    FTableMethodHandlesInt(MethodHandles.Lookup lookup, Class<O> owner, String... fieldNames) {
        super(lookup, owner, int.class, fieldNames);
    }

	FTableMethodHandlesInt(MethodHandles.Lookup lookup, Field[] fields) {
		super(lookup, int.class, fields);
	}

    public int unsafeGet(O owner, int index) throws Throwable {
        return (int) indexGetters[index].invoke(owner);
    }
    public int unsafeGetExact(O owner, int index) throws Throwable {
        return (int) indexGetters[index].invokeExact(owner);
    }

    public void unsafeSet(O owner, int index, int newValue) throws Throwable {
        indexSetters[index].invoke(owner, newValue);
    }

    public void unsafeSetExact(O owner, int index, int newValue) throws Throwable {
        indexSetters[index].invokeExact(owner, newValue);
    }
}
