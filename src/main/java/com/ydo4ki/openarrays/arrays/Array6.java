
package com.ydo4ki.openarrays.arrays;


public class Array6<T> extends Array5<T> {
	public T e5;

	public Array6(T e0, T e1, T e2, T e3, T e4, T e5) {
		super(e0, e1, e2, e3, e4);
		this.e5 = e5;
	} public Array6() {}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toJavaArray() {
		return (T[]) new Object[]{e0, e1, e2, e3, e4, e5};
	}

	@Override
	public int length() {
		return 6;
	}
}
