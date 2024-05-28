package com.ydo4ki.openarrays;


public abstract class ShortArray extends AnyArray<Short> {

	public abstract short get(int index);

	public abstract void set(int index, short element);

	public abstract short[] toJavaArray();

	@Override
	protected Short genericGet(int index) {
		return get(index);
	}

	@Override
	protected void genericSet(int index, Short value) {
		set(index, value);
	}

	@Override
	public ShortArray clone() {
		return (ShortArray) super.clone();
	}
}

