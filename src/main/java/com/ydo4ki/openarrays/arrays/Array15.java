
package com.ydo4ki.openarrays.arrays;


public class Array15<T> extends Array14<T> {
	public T e14;

	public Array15(T e0, T e1, T e2, T e3, T e4, T e5, T e6, T e7, T e8, T e9, T e10, T e11, T e12, T e13, T e14) {
		super(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13);
		this.e14 = e14;
	} public Array15() {}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toJavaArray() {
		return (T[]) new Object[]{e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14};
	}

	@Override
	public int length() {
		return 15;
	}
}
