package com.ydo4ki.openarrays.arrays;


import com.ydo4ki.openarrays.ftable.FTable;
import com.ydo4ki.openarrays.iterators.Iterators;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Iterator;

public abstract class Array<T> extends AnyArray<T> {

	public static <T> Array<T> dynamic(int length) {
		return new ArrayDynamic<>(length);
	}

	public abstract T get(int index);

	public abstract void set(int index, T element);

	public abstract T[] toJavaArray();

	public void fill(T value) {
		for (int i = 0, len = length(); i < len; i++)
			set(i, value);
	}
	public void fill(int fromIndex, int toIndex, T value) {
		rangeCheck(fromIndex, toIndex);
		for (int i = fromIndex; i < toIndex; i++)
			set(i, value);
	}

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

	static final FTable<Array<?>, Object> table16 = FTable.fast(MethodHandles.lookup(), accumulateFields("com.ydo4ki.openarrays.arrays.Array"));
	private static Field[] accumulateFields(String baseArrayName) {
		Field[] fields = new Field[16];
		for (int i = 0; i < fields.length; i++) {
			try {
				fields[i] = Class.forName(baseArrayName + (i+1)).getDeclaredField("e"+i);
			} catch (NoSuchFieldException | ClassNotFoundException e) {
				throw new AssertionError(e);
			}
		}
		return fields;
	}
}
