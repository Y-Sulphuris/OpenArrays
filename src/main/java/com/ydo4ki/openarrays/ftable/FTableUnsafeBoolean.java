package com.ydo4ki.openarrays.ftable;

import java.lang.reflect.Field;

public class FTableUnsafeBoolean<O> extends FTableUnsafe<O> implements FTableBoolean<O> {

    FTableUnsafeBoolean(Class<O> owner, Field[] fields) {
        super(owner, boolean.class, fields);
    }
	FTableUnsafeBoolean(Field[] fields) {
		super(fields);
	}

    @Override
    public boolean unsafeGet(O owner, int index) throws Throwable {
        assert U != null;
        return ((sun.misc.Unsafe)U).getBoolean(owner, fieldOffsets[index]);
    }

    @Override
    public boolean unsafeGetExact(O owner, int index) throws Throwable {
        return unsafeGet(owner, index);
    }

    @Override
    public void unsafeSet(O owner, int index, boolean newValue) throws Throwable {
        assert U != null;
        ((sun.misc.Unsafe)U).putBoolean(owner, fieldOffsets[index], newValue);
    }

    @Override
    public void unsafeSetExact(O owner, int index, boolean newValue) throws Throwable {
        unsafeSet(owner, index, newValue);
    }
}
