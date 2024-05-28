package com.ydo4ki.openarrays.ftable;

import java.lang.invoke.MethodHandles;

public class FTableMethodHandlesByte<O> extends FTableMethodHandles<O> implements FTableByte<O> {
    FTableMethodHandlesByte(MethodHandles.Lookup lookup, Class<O> owner, String... fieldNames) {
        super(lookup, owner, byte.class, fieldNames);
    }

    public byte unsafeGet(O owner, int index) throws Throwable {
        return (byte) indexGetters[index].invoke(owner);
    }
    public byte unsafeGetExact(O owner, int index) throws Throwable {
        return (byte) indexGetters[index].invokeExact(owner);
    }

    public void unsafeSet(O owner, int index, byte newValue) throws Throwable {
        indexSetters[index].invoke(owner, newValue);
    }

    public void unsafeSetExact(O owner, int index, byte newValue) throws Throwable {
        indexSetters[index].invokeExact(owner, newValue);
    }
}

