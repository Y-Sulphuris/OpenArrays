package com.ydo4ki.openarrays;

public interface Array<T> extends AnyArray<T> {

    T get(int index);

    void set(int index, T value);
}

