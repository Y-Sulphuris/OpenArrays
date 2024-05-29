package com.ydo4ki.openarrays.arrays;

public abstract class BooleanOpenArray extends AnyOpenArray<Boolean> {

	public abstract boolean get(int index);

	public abstract void set(int index, boolean element);

	public abstract boolean[] toJavaArray();

	@Override
	protected Boolean getObject(int index) {
		return get(index);
	}

	@Override
	protected void setObject(int index, Boolean value) {
		set(index, value);
	}

	@Override
	public BooleanOpenArray clone() {
		return (BooleanOpenArray) super.clone();
	}

}


