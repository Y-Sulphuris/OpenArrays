package com.ydo4ki.openarrays.ftable;

import java.lang.reflect.Field;

public class FTableUnsafeDouble<O> extends FTableUnsafe<O> implements FTableDouble<O> {

    FTableUnsafeDouble(Class<O> owner, Field[] fields) {
        super(owner, double.class, fields);
    }
	FTableUnsafeDouble(Field[] fields) {
		super(double.class, fields);
	}

    @Override
    public double unsafeGet(O owner, int index) throws Throwable {
        assert U != null;
        return ((sun.misc.Unsafe)U).getDouble(owner, fieldOffsets[index]);
    }

    @Override
    public double unsafeGetExact(O owner, int index) throws Throwable {
        return unsafeGet(owner, index);
    }

    @Override
    public void unsafeSet(O owner, int index, double newValue) throws Throwable {
        assert U != null;
        ((sun.misc.Unsafe)U).putDouble(owner, fieldOffsets[index], newValue);
    }

    @Override
    public void unsafeSetExact(O owner, int index, double newValue) throws Throwable {
        unsafeSet(owner, index, newValue);
    }
}
