package com.ydo4ki.openarrays.ftable;

import java.lang.reflect.Field;

public class FTableUnsafeShort<O> extends FTableUnsafe<O> implements FTableShort<O> {

    FTableUnsafeShort(Class<O> owner, Field[] fields) {
        super(owner, short.class, fields);
    }

    @Override
    public short unsafeGet(O owner, int index) throws Throwable {
        assert U != null;
        return ((sun.misc.Unsafe)U).getShort(owner, fieldOffsets[index]);
    }

    @Override
    public short unsafeGetExact(O owner, int index) throws Throwable {
        return unsafeGet(owner, index);
    }

    @Override
    public void unsafeSet(O owner, int index, short newValue) throws Throwable {
        assert U != null;
        ((sun.misc.Unsafe)U).putShort(owner, fieldOffsets[index], newValue);
    }

    @Override
    public void unsafeSetExact(O owner, int index, short newValue) throws Throwable {
        unsafeSet(owner, index, newValue);
    }
}
