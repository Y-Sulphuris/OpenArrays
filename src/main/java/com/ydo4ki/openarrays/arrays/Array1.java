package com.ydo4ki.openarrays.arrays;

import com.ydo4ki.openarrays.iterators.Iterators;

import java.util.Iterator;

public class Array1<T> extends OpenArray<T> {
	public T e0;

	public Array1(T e0) {
		this.e0 = e0;
	} public Array1() {}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toJavaArray() {
		return (T[]) new Object[]{e0};
	}

	@Override
	public int length() {
		return 1;
	}

	@Override
	public Iterator<T> iterator() {
		return Iterators.singleton(e0);
	}

	@Override
	public T get(int index) {
		if (index != 0) throw clearLastStackElements(new ArrayIndexOutOfBoundsException(index), 1);
		return this.e0;
	}

	@Override
	public void set(int index, T element) {
		if (index != 0) throw clearLastStackElements(new ArrayIndexOutOfBoundsException(index), 1);
		this.e0 = element;
	}

}
