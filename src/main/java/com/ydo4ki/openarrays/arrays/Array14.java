
package com.ydo4ki.openarrays.arrays;


public class Array14<T> extends Array13<T> {
	public T e13;

	public Array14(T e0, T e1, T e2, T e3, T e4, T e5, T e6, T e7, T e8, T e9, T e10, T e11, T e12, T e13) {
		super(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12);
		this.e13 = e13;
	} public Array14() {}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toJavaArray() {
		return (T[]) new Object[]{e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13};
	}

	@Override
	public int length() {
		return 14;
	}
}
