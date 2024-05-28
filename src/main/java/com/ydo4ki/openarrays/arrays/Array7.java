
package com.ydo4ki.openarrays.arrays;


public class Array7<T> extends Array6<T> {
	public T e6;

	public Array7(T e0, T e1, T e2, T e3, T e4, T e5, T e6) {
		super(e0, e1, e2, e3, e4, e5);
		this.e6 = e6;
	} public Array7() {}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toJavaArray() {
		return (T[]) new Object[]{e0, e1, e2, e3, e4, e5, e6};
	}

	@Override
	public int length() {
		return 7;
	}
}
