package com.ydo4ki.openarrays.arrays;

import com.ydo4ki.openarrays.ftable.FTable;
import java.lang.invoke.MethodHandles;

public class Array5<T> extends OpenArray<T> {
	public T e0, e1, e2, e3, e4;

	public Array5(T e0, T e1, T e2, T e3, T e4) {
		this.e0 = e0;
		this.e1 = e1;
		this.e2 = e2;
		this.e3 = e3;
		this.e4 = e4;
	} public Array5() {}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toJavaArray() {
		return (T[]) new Object[]{e0, e1, e2, e3, e4};
	}

	@Override
	public int length() {
		return 5;
	}


	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		rangeCheck(index);
		try {
			return (T) ftable.unsafeGet(this, index);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void set(int index, T element) {
		rangeCheck(index);
		try {
			ftable.unsafeSet(this, index, element);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings({"rawtypes"})
	private static final FTable ftable = FTable.fast(MethodHandles.lookup(), Array5.class, Object.class, "e", 5);
}
