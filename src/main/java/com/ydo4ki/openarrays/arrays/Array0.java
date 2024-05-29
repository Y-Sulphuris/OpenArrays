package com.ydo4ki.openarrays.arrays;

import com.ydo4ki.openarrays.OpenArrays;

import java.util.Collections;
import java.util.Iterator;

public class Array0<T> extends OpenArray<T> {
    @Override
    public T get(int index) {
        throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public void set(int index, T element) {
        throw new ArrayIndexOutOfBoundsException();
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] toJavaArray() {
        return (T[]) OpenArrays.EMPTY_ARRAY;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return Collections.emptyIterator();
    }
}
