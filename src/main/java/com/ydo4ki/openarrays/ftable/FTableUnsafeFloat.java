package com.ydo4ki.openarrays.ftable;

import java.lang.reflect.Field;

public class FTableUnsafeFloat<O> extends FTableUnsafe<O> implements FTableFloat<O> {

    FTableUnsafeFloat(Class<O> owner, Field[] fields) {
        super(owner, float.class, fields);
    }

    @Override
    public float unsafeGet(O owner, int index) throws Throwable {
        assert U != null;
        return ((sun.misc.Unsafe)U).getFloat(owner, fieldOffsets[index]);
    }

    @Override
    public float unsafeGetExact(O owner, int index) throws Throwable {
        return unsafeGet(owner, index);
    }

    @Override
    public void unsafeSet(O owner, int index, float newValue) throws Throwable {
        assert U != null;
        ((sun.misc.Unsafe)U).putFloat(owner, fieldOffsets[index], newValue);
    }

    @Override
    public void unsafeSetExact(O owner, int index, float newValue) throws Throwable {
        unsafeSet(owner, index, newValue);
    }
}
