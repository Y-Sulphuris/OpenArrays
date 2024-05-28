package com.ydo4ki.openarrays.ftable;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;

class FTableMethodHandlesObject<O, T> extends FTableMethodHandles<O> implements FTable<O, T> {
    FTableMethodHandlesObject(MethodHandles.Lookup lookup, Class<? extends O> owner, Class<T> fieldType, String[] fieldNames) {
        super(lookup, owner, fieldType, fieldNames);
    }

	FTableMethodHandlesObject(MethodHandles.Lookup lookup, Field[] fields) {
        super(lookup, fields);
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

    @Override
    public int size() {
        return indexGetters.length;
    }
}
