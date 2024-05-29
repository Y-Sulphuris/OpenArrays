package com.ydo4ki.openarrays.arrays;

public abstract class FloatOpenArray extends AnyOpenArray<Float> {

	public abstract float get(int index);

	public abstract void set(int index, float element);

	public abstract float[] toJavaArray();

	@Override
	protected Float getObject(int index) {
		return get(index);
	}

	@Override
	protected void setObject(int index, Float value) {
		set(index, value);
	}

	@Override
	public FloatOpenArray clone() {
		return (FloatOpenArray) super.clone();
	}
}


