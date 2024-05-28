package com.ydo4ki.openarrays.arrays;

public class Array3<T> extends Array2<T> {
	public T e2;

	public Array3(T e0, T e1, T e2) {
		super(e0, e1);
		this.e2 = e2;
	} public Array3() {}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toJavaArray() {
		return (T[]) new Object[]{e0, e1, e2};
	}

	@Override
	public int length() {
		return 3;
	}
}
