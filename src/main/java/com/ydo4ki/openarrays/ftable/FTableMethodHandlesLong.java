package com.ydo4ki.openarrays.ftable;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;

class FTableMethodHandlesLong<O> extends FTableMethodHandles<O> implements FTableLong<O> {
    FTableMethodHandlesLong(MethodHandles.Lookup lookup, Class<O> owner, String... fieldNames) {
        super(lookup, owner, long.class, fieldNames);
    }

	FTableMethodHandlesLong(MethodHandles.Lookup lookup, Field[] fields) {
		super(lookup, long.class, fields);
	}

    @Override
    public long unsafeGet(O owner, int index) throws Throwable {
        return (long) indexGetters[index].invoke(owner);
    }
    public long unsafeGetExact(O owner, int index) throws Throwable {
        return (long) indexGetters[index].invokeExact(owner);
    }

    public void unsafeSet(O owner, int index, long newValue) throws Throwable {
        indexSetters[index].invoke(owner, newValue);
    }

    public void unsafeSetExact(O owner, int index, long newValue) throws Throwable {
        indexSetters[index].invokeExact(owner, newValue);
    }
}
