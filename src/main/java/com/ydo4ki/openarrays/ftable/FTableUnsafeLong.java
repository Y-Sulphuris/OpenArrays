package com.ydo4ki.openarrays.ftable;

import java.lang.reflect.Field;

public class FTableUnsafeLong<O> extends FTableUnsafe<O> implements FTableLong<O> {

    FTableUnsafeLong(Class<O> owner, Field[] fields) {
        super(owner, long.class, fields);
    }

    @Override
    public long unsafeGet(O owner, int index) throws Throwable {
        assert U != null;
        return ((sun.misc.Unsafe)U).getLong(owner, fieldOffsets[index]);
    }

    @Override
    public long unsafeGetExact(O owner, int index) throws Throwable {
        return unsafeGet(owner, index);
    }

    @Override
    public void unsafeSet(O owner, int index, long newValue) throws Throwable {
        assert U != null;
        ((sun.misc.Unsafe)U).putLong(owner, fieldOffsets[index], newValue);
    }

    @Override
    public void unsafeSetExact(O owner, int index, long newValue) throws Throwable {
        unsafeSet(owner, index, newValue);
    }
}
