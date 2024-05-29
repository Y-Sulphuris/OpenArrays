package com.ydo4ki.openarrays.arrays;

import com.ydo4ki.openarrays.ftable.FTable;
import java.lang.invoke.MethodHandles;

public class Array16<T> extends Array<T> {
	public T e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15;

	public Array16(T e0, T e1, T e2, T e3, T e4, T e5, T e6, T e7, T e8, T e9, T e10, T e11, T e12, T e13, T e14, T e15) {
		this.e0 = e0;
		this.e1 = e1;
		this.e2 = e2;
		this.e3 = e3;
		this.e4 = e4;
		this.e5 = e5;
		this.e6 = e6;
		this.e7 = e7;
		this.e8 = e8;
		this.e9 = e9;
		this.e10 = e10;
		this.e11 = e11;
		this.e12 = e12;
		this.e13 = e13;
		this.e14 = e14;
		this.e15 = e15;
	} public Array16() {}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toJavaArray() {
		return (T[]) new Object[]{e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15};
	}

	@Override
	public int length() {
		return 16;
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
	private static final FTable ftable = FTable.fast(MethodHandles.lookup(), Array16.class, Object.class, "e", 16);
}
