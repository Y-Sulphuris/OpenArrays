package com.ydo4ki.openarrays.arrays;

import com.ydo4ki.openarrays.ftable.FTable;
import com.ydo4ki.openarrays.iterators.Iterators;

import java.util.Iterator;

public class Array2<T> extends Array1<T> {
    public T e1;

	public Array2(T e0, T e1) {
		super(e0);
		this.e1 = e1;
	} public Array2() {}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		rangeCheck(index);
		try {
			return (T) table().unsafeGet(this, index);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void set(int index, T element) {
		rangeCheck(index);
		try {
			table().unsafeSet(this, index, element);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	FTable<Array<?>, Object> table() {
		return table16;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toJavaArray() {
		return (T[]) new Object[]{e0,e1};
	}

	@Override
	public int length() {
		return 2;
	}

	@Override
	public Iterator<T> iterator() {
		return Iterators.ofArray(this);
	}
}
