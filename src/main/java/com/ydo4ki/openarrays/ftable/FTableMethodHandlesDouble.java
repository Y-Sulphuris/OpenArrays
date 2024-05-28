package com.ydo4ki.openarrays.ftable;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;

class FTableMethodHandlesDouble<O> extends FTableMethodHandles<O> implements FTableDouble<O> {
    FTableMethodHandlesDouble(MethodHandles.Lookup lookup, Class<O> owner, String... fieldNames) {
        super(lookup, owner, double.class, fieldNames);
    }

	FTableMethodHandlesDouble(MethodHandles.Lookup lookup, Field[] fields) {
		super(lookup, double.class, fields);
	}

    public double unsafeGet(O owner, int index) throws Throwable {
        return (double) indexGetters[index].invoke(owner);
    }
    public double unsafeGetExact(O owner, int index) throws Throwable {
        return (double) indexGetters[index].invokeExact(owner);
    }

    public void unsafeSet(O owner, int index, double newValue) throws Throwable {
        indexSetters[index].invoke(owner, newValue);
    }

    public void unsafeSetExact(O owner, int index, double newValue) throws Throwable {
        indexSetters[index].invokeExact(owner, newValue);
    }
}
