package com.ydo4ki.openarrays.ftable;

public interface FTableShort<O> {
    short unsafeGet(O owner, int index) throws Throwable;

    short unsafeGetExact(O owner, int index) throws Throwable;

    void unsafeSet(O owner, int index, short newValue) throws Throwable;

    void unsafeSetExact(O owner, int index, short newValue) throws Throwable;
}
