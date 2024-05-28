package com.ydo4ki.openarrays.arrays;

public class Array4<T> extends Array3<T> {
	public T e3;

	public Array4(T e0, T e1, T e2, T e3) {
		super(e0, e1, e2);
		this.e3 = e3;
	} public Array4() {}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toJavaArray() {
		return (T[]) new Object[]{e0, e1, e2, e3};
	}

	@Override
	public int length() {
		return 4;
	}
}
