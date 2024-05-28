package com.ydo4ki.openarrays;

public abstract class BooleanArray extends AnyArray<Boolean> {

	public abstract boolean get(int index);

	public abstract void set(int index, boolean element);

	public abstract boolean[] toJavaArray();

	@Override
	protected Boolean genericGet(int index) {
		return get(index);
	}

	@Override
	protected void genericSet(int index, Boolean value) {
		set(index, value);
	}

	@Override
	public BooleanArray clone() {
		return (BooleanArray) super.clone();
	}

}


