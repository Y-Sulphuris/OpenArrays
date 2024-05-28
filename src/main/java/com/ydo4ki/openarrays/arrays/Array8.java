
package com.ydo4ki.openarrays.arrays;


public class Array8<T> extends Array7<T> {
	public T e7;

	public Array8(T e0, T e1, T e2, T e3, T e4, T e5, T e6, T e7) {
		super(e0, e1, e2, e3, e4, e5, e6);
		this.e7 = e7;
	} public Array8() {}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toJavaArray() {
		return (T[]) new Object[]{e0, e1, e2, e3, e4, e5, e6, e7};
	}

	@Override
	public int length() {
		return 8;
	}
}
