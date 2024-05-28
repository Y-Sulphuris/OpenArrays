package com.ydo4ki.openarrays.ftable;

import java.lang.reflect.Field;

public class FTableUnsafeInt<O> extends FTableUnsafe<O> implements FTableInt<O> {

    FTableUnsafeInt(Class<O> owner, Field[] fields) {
        super(owner, int.class, fields);
    }

    @Override
    public int unsafeGet(O owner, int index) throws Throwable {
        assert U != null;
        return ((sun.misc.Unsafe)U).getInt(owner, fieldOffsets[index]);
    }

    @Override
    public int unsafeGetExact(O owner, int index) throws Throwable {
        return unsafeGet(owner, index);
    }

    @Override
    public void unsafeSet(O owner, int index, int newValue) throws Throwable {
        assert U != null;
        ((sun.misc.Unsafe)U).putInt(owner, fieldOffsets[index], newValue);
    }

    @Override
    public void unsafeSetExact(O owner, int index, int newValue) throws Throwable {
        unsafeSet(owner, index, newValue);
    }
}
