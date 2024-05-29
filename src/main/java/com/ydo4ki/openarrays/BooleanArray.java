package com.ydo4ki.openarrays;

public interface BooleanArray extends AnyArray<Boolean> {

    boolean get(int index);

    void set(int index, boolean value);
}
