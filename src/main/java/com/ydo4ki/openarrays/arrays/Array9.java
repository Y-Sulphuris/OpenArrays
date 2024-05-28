
package com.ydo4ki.openarrays.arrays;


public class Array9<T> extends Array8<T> {
	public T e8;

	public Array9(T e0, T e1, T e2, T e3, T e4, T e5, T e6, T e7, T e8) {
		super(e0, e1, e2, e3, e4, e5, e6, e7);
		this.e8 = e8;
	} public Array9() {}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toJavaArray() {
		return (T[]) new Object[]{e0, e1, e2, e3, e4, e5, e6, e7, e8};
	}

	@Override
	public int length() {
		return 9;
	}
}
