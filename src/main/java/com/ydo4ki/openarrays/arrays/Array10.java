
package com.ydo4ki.openarrays.arrays;


public class Array10<T> extends Array9<T> {
	public T e9;

	public Array10(T e0, T e1, T e2, T e3, T e4, T e5, T e6, T e7, T e8, T e9) {
		super(e0, e1, e2, e3, e4, e5, e6, e7, e8);
		this.e9 = e9;
	} public Array10() {}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toJavaArray() {
		return (T[]) new Object[]{e0, e1, e2, e3, e4, e5, e6, e7, e8, e9};
	}

	@Override
	public int length() {
		return 10;
	}
}
