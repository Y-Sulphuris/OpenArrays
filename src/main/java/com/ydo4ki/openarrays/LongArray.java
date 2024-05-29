package com.ydo4ki.openarrays;

public interface LongArray extends AnyArray<Long> {

    long get(int index);

    void set(int index, long value);
}
