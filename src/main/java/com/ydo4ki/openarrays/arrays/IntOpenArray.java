package com.ydo4ki.openarrays.arrays;


public abstract class IntOpenArray extends AnyOpenArray<Integer> {

	public abstract int get(int index);

	public abstract void set(int index, int element);

	public abstract int[] toJavaArray();

	@Override
	protected Integer getObject(int index) {
		return get(index);
	}

	@Override
	protected void setObject(int index, Integer value) {
		set(index, value);
	}

	@Override
	public IntOpenArray clone() {
		return (IntOpenArray) super.clone();
	}
}

