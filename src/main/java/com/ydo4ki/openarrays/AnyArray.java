package com.ydo4ki.openarrays;

import java.util.RandomAccess;

public interface AnyArray<T> extends java.io.Serializable, RandomAccess, Cloneable, Iterable<T> {
    int length();
}
