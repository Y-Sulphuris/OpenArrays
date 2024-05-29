package com.ydo4ki.openarrays.arrays;


public abstract class LongOpenArray extends AnyOpenArray<Long> {

	public abstract long get(int index);

	public abstract void set(int index, long element);

	public abstract long[] toJavaArray();

	@Override
	protected Long getObject(int index) {
		return get(index);
	}

	@Override
	protected void setObject(int index, Long value) {
		set(index, value);
	}

	@Override
	public LongOpenArray clone() {
		return (LongOpenArray) super.clone();
	}
}
