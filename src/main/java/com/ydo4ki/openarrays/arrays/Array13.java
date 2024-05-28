
package com.ydo4ki.openarrays.arrays;


public class Array13<T> extends Array12<T> {
	public T e12;

	public Array13(T e0, T e1, T e2, T e3, T e4, T e5, T e6, T e7, T e8, T e9, T e10, T e11, T e12) {
		super(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11);
		this.e12 = e12;
	} public Array13() {}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toJavaArray() {
		return (T[]) new Object[]{e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12};
	}

	@Override
	public int length() {
		return 13;
	}
}
