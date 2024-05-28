package com.ydo4ki.openarrays.arrays;


public abstract class LongArray extends AnyArray<Long> {

	public abstract long get(int index);

	public abstract void set(int index, long element);

	public abstract long[] toJavaArray();

	@Override
	protected Long genericGet(int index) {
		return get(index);
	}

	@Override
	protected void genericSet(int index, Long value) {
		set(index, value);
	}

	@Override
	public LongArray clone() {
		return (LongArray) super.clone();
	}
}
