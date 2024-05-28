package com.ydo4ki.openarrays.arrays;


public abstract class IntArray extends AnyArray<Integer> {

	public abstract int get(int index);

	public abstract void set(int index, int element);

	public abstract int[] toJavaArray();

	@Override
	protected Integer genericGet(int index) {
		return get(index);
	}

	@Override
	protected void genericSet(int index, Integer value) {
		set(index, value);
	}

	@Override
	public IntArray clone() {
		return (IntArray) super.clone();
	}
}

