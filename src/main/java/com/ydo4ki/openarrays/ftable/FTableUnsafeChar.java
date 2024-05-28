package com.ydo4ki.openarrays.ftable;

import java.lang.reflect.Field;

public class FTableUnsafeChar<O> extends FTableUnsafe<O> implements FTableChar<O> {

    FTableUnsafeChar(Class<O> owner, Field[] fields) {
        super(owner, char.class, fields);
    }

    @Override
    public char unsafeGet(O owner, int index) throws Throwable {
        assert U != null;
        return ((sun.misc.Unsafe)U).getChar(owner, fieldOffsets[index]);
    }

    @Override
    public char unsafeGetExact(O owner, int index) throws Throwable {
        return unsafeGet(owner, index);
    }

    @Override
    public void unsafeSet(O owner, int index, char newValue) throws Throwable {
        assert U != null;
        ((sun.misc.Unsafe)U).putChar(owner, fieldOffsets[index], newValue);
    }

    @Override
    public void unsafeSetExact(O owner, int index, char newValue) throws Throwable {
        unsafeSet(owner, index, newValue);
    }
}
