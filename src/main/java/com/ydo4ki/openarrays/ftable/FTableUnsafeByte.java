package com.ydo4ki.openarrays.ftable;

import java.lang.reflect.Field;

public class FTableUnsafeByte<O> extends FTableUnsafe<O> implements FTableByte<O> {

    FTableUnsafeByte(Class<O> owner, Field[] fields) {
        super(owner, byte.class, fields);
    }

    @Override
    public byte unsafeGet(O owner, int index) throws Throwable {
        assert U != null;
        return ((sun.misc.Unsafe)U).getByte(owner, fieldOffsets[index]);
    }

    @Override
    public byte unsafeGetExact(O owner, int index) throws Throwable {
        return unsafeGet(owner, index);
    }

    @Override
    public void unsafeSet(O owner, int index, byte newValue) throws Throwable {
        assert U != null;
        ((sun.misc.Unsafe)U).putByte(owner, fieldOffsets[index], newValue);
    }

    @Override
    public void unsafeSetExact(O owner, int index, byte newValue) throws Throwable {
        unsafeSet(owner, index, newValue);
    }
}
