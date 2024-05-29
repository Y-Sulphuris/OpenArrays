package com.ydo4ki.openarrays.arrays;


public class Array2<T> extends Array<T> {
	public T e0, e1;

	public Array2(T e0, T e1) {
		this.e0 = e0;
		this.e1 = e1;
	} public Array2() {}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toJavaArray() {
		return (T[]) new Object[]{e0, e1};
	}

	@Override
	public int length() {
		return 2;
	}


	@Override
	public T get(int index) {
		switch (index) {
			case 0: return e0;
			case 1: return e1;
			default:
				throw clearLastStackElements(new ArrayIndexOutOfBoundsException(index), 1);
		}
	}

	@Override
	public void set(int index, T element) {
		switch (index) {
			case 0:
				this.e0 = element;
				break;
			case 1:
				this.e1 = element;
				break;
			default:
				throw clearLastStackElements(new ArrayIndexOutOfBoundsException(index), 1);
		}
	}
}
