package com.ydo4ki.openarrays.arrays;


import com.ydo4ki.openarrays.iterators.Iterators;

import java.util.Iterator;

public abstract class Array<T> extends AnyArray<T> {

	public abstract T get(int index);

	public abstract void set(int index, T element);

	public abstract T[] toJavaArray();

	@Override
	protected T genericGet(int index) {
		return get(index);
	}

	@Override
	protected void genericSet(int index, T value) {
		set(index, value);
	}

	@Override
	public Array<T> clone() {
		return (Array<T>) super.clone();
	}

	@Override
	public Iterator<T> iterator() {
		return Iterators.ofArray(this);
	}

}
