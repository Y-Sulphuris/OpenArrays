package com.ydo4ki.openarrays.iterators;

import com.ydo4ki.openarrays.arrays.Array;

import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;

public final class Iterators {
    private Iterators() throws InstantiationException {
        throw new InstantiationException("Nope.");
    }

    public static <T> Iterator<T> ofArray(T[] array) {
        Objects.requireNonNull(array);
        return new Iterator<T>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < array.length;
            }

            @Override
            public T next() {
                return array[i++];
            }
        };
    }

    public static <T> Iterator<T> ofArray(Array<T> array) {
        Objects.requireNonNull(array);
        return new Iterator<T>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < array.length();
            }

            @Override
            public T next() {
                return array.get(i++);
            }
        };
    }

    public static <T> Iterator<T> empty() {
        return Collections.emptyIterator();
    }

    public static <T> Iterator<T> singleton(T obj) {
        return new Iterator<T>() {
            boolean next = true;
            @Override
            public boolean hasNext() {
                return next;
            }

            @Override
            public T next() {
                next = false;
                return obj;
            }
        };
    }
}
