package com.ydo4ki.openarrays.arrays;

import java.util.RandomAccess;

public abstract class AnyArray<T> implements java.io.Serializable, RandomAccess, Cloneable, Iterable<T> {
	public abstract int length();

	protected abstract T genericGet(int index);

	protected abstract void genericSet(int index, T value);

	@SuppressWarnings("unchecked")
	@Override
	public AnyArray<T> clone() {
		try {
			return (AnyArray<T>) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}
}
