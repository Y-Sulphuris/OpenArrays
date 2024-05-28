package com.ydo4ki.openarrays;


public abstract class Array<T> extends AnyArray {

	public abstract T get(int index);

	public abstract void set(int index, T element);

	public abstract T[] toJavaArray();

	@SuppressWarnings("unchecked")
	@Override
	public Array<T> clone() {
		return (Array<T>) super.clone();
	}
}
