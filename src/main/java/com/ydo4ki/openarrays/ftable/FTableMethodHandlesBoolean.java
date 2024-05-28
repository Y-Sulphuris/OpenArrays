package com.ydo4ki.openarrays.ftable;

import java.lang.invoke.MethodHandles;

public class FTableMethodHandlesBoolean<O> extends FTableMethodHandles<O> implements FTableBoolean<O> {
    FTableMethodHandlesBoolean(MethodHandles.Lookup lookup, Class<O> owner, String... fieldNames) {
        super(lookup, owner, boolean.class, fieldNames);
    }

    public boolean unsafeGet(O owner, int index) throws Throwable {
        return (boolean) indexGetters[index].invoke(owner);
    }
    public boolean unsafeGetExact(O owner, int index) throws Throwable {
        return (boolean) indexGetters[index].invokeExact(owner);
    }

    public void unsafeSet(O owner, int index, boolean newValue) throws Throwable {
        indexSetters[index].invoke(owner, newValue);
    }

    public void unsafeSetExact(O owner, int index, boolean newValue) throws Throwable {
        indexSetters[index].invokeExact(owner, newValue);
    }
}
