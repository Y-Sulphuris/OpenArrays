package com.ydo4ki.openarrays.ftable;

import java.lang.invoke.MethodHandles;

public class FTableMethodHandlesFloat<O> extends FTableMethodHandles<O> implements FTableFloat<O> {
    FTableMethodHandlesFloat(MethodHandles.Lookup lookup, Class<O> owner, String... fieldNames) {
        super(lookup, owner, float.class, fieldNames);
    }

    public float unsafeGet(O owner, int index) throws Throwable {
        return (float) indexGetters[index].invoke(owner);
    }
    public float unsafeGetExact(O owner, int index) throws Throwable {
        return (float) indexGetters[index].invokeExact(owner);
    }

    public void unsafeSet(O owner, int index, float newValue) throws Throwable {
        indexSetters[index].invoke(owner, newValue);
    }

    public void unsafeSetExact(O owner, int index, float newValue) throws Throwable {
        indexSetters[index].invokeExact(owner, newValue);
    }
}
