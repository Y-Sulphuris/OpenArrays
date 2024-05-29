package com.ydo4ki.openarrays.arrays;


public abstract class ShortOpenArray extends AnyOpenArray<Short> {

	public abstract short get(int index);

	public abstract void set(int index, short element);

	public abstract short[] toJavaArray();

	@Override
	protected Short getObject(int index) {
		return get(index);
	}

	@Override
	protected void setObject(int index, Short value) {
		set(index, value);
	}

	@Override
	public ShortOpenArray clone() {
		return (ShortOpenArray) super.clone();
	}
}

