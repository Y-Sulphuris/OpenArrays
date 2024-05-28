package com.ydo4ki.openarrays.arrays;

public abstract class FloatArray extends AnyArray<Float> {

	public abstract float get(int index);

	public abstract void set(int index, float element);

	public abstract float[] toJavaArray();

	@Override
	protected Float genericGet(int index) {
		return get(index);
	}

	@Override
	protected void genericSet(int index, Float value) {
		set(index, value);
	}

	@Override
	public FloatArray clone() {
		return (FloatArray) super.clone();
	}
}


