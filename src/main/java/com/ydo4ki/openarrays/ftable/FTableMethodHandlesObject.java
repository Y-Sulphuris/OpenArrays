package com.ydo4ki.openarrays.ftable;

import java.lang.invoke.MethodHandles;

public class FTableMethodHandlesObject<O, T> extends FTableMethodHandles<O> implements FTable<O, T> {
    FTableMethodHandlesObject(MethodHandles.Lookup lookup, Class<O> owner, Class<T> fieldType, String[] fieldNames) {
        super(lookup, owner, fieldType, fieldNames);
    }

    @SuppressWarnings("unchecked")
    public T unsafeGet(O owner, int index) throws Throwable {
        return (T) indexGetters[index].invoke(owner);
    }
    @SuppressWarnings("unchecked")
    public T unsafeGetExact(O owner, int index) throws Throwable {
        return (T) indexGetters[index].invokeExact(owner);
    }

    public void unsafeSet(O owner, int index, T newValue) throws Throwable {
        indexSetters[index].invoke(owner, newValue);
    }

    public void unsafeSetExact(O owner, int index, T newValue) throws Throwable {
        indexSetters[index].invokeExact(owner, newValue);
    }
}
