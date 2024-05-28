package com.ydo4ki.openarrays.arrays;

public abstract class DoubleArray extends AnyArray<Double> {

	public abstract double get(int index);

	public abstract void set(int index, double element);

	public abstract double[] toJavaArray();

	@Override
	protected Double genericGet(int index) {
		return get(index);
	}

	@Override
	protected void genericSet(int index, Double value) {
		set(index, value);
	}

	@Override
	public DoubleArray clone() {
		return (DoubleArray) super.clone();
	}
}


