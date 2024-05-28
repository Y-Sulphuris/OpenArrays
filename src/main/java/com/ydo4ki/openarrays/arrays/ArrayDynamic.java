package com.ydo4ki.openarrays.arrays;

import java.util.Arrays;

class ArrayDynamic<T> extends Array<T> {
	private T[] data;

	@SuppressWarnings("unchecked")
	ArrayDynamic(int len) {
		this.data = (T[]) new Object[len];
	}


	@Override
	public T get(int index) {
		try {
			return data[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw clearLastStackElements(e, 1);
		}
	}

	@Override
	public void set(int index, T element) {
		try {
			data[index] = element;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw clearLastStackElements(e, 1);
		}
	}

	@Override
	public T[] toJavaArray() {
		return data.clone();
	}

	@Override
	public int length() {
		return data.length;
	}

	@Override
	public void fill(T value) {
		Arrays.fill(data, value);
	}

	@Override
	public void fill(int fromIndex, int toIndex, T value) {
		Arrays.fill(data, fromIndex, toIndex, value);
	}

	@Override
	public Array<T> clone() {
		ArrayDynamic<T> c = (ArrayDynamic<T>)super.clone();
		c.data = data.clone();
		return c;
	}
}
