
package com.ydo4ki.openarrays.arrays;


public class Array5<T> extends Array4<T> {
	public T e4;

	public Array5(T e0, T e1, T e2, T e3, T e4) {
		super(e0, e1, e2, e3);
		this.e4 = e4;
	} public Array5() {}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toJavaArray() {
		return (T[]) new Object[]{e0, e1, e2, e3, e4};
	}

	@Override
	public int length() {
		return 5;
	}
}
