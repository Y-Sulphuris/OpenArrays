package com.ydo4ki.openarrays.ftable;

import java.lang.invoke.MethodHandles;

public class FTableMethodHandlesShort<O> extends FTableMethodHandles<O> implements FTableShort<O> {
    FTableMethodHandlesShort(MethodHandles.Lookup lookup, Class<O> owner, String... fieldNames) {
        super(lookup, owner, short.class, fieldNames);
    }

    public short unsafeGet(O owner, int index) throws Throwable {
        return (short) indexGetters[index].invoke(owner);
    }
    public short unsafeGetExact(O owner, int index) throws Throwable {
        return (short) indexGetters[index].invokeExact(owner);
    }

    public void unsafeSet(O owner, int index, short newValue) throws Throwable {
        indexSetters[index].invoke(owner, newValue);
    }

    public void unsafeSetExact(O owner, int index, short newValue) throws Throwable {
        indexSetters[index].invokeExact(owner, newValue);
    }
}
