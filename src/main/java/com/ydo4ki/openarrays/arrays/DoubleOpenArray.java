package com.ydo4ki.openarrays.arrays;

public abstract class DoubleOpenArray extends AnyOpenArray<Double> {

	public abstract double get(int index);

	public abstract void set(int index, double element);

	public abstract double[] toJavaArray();

	@Override
	protected Double getObject(int index) {
		return get(index);
	}

	@Override
	protected void setObject(int index, Double value) {
		set(index, value);
	}

	@Override
	public DoubleOpenArray clone() {
		return (DoubleOpenArray) super.clone();
	}
}


