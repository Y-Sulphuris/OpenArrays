package com.ydo4ki.openarrays.arrays;

import com.ydo4ki.openarrays.ftable.FTable;

import java.lang.invoke.MethodHandles;

public class Array24<T> extends Array16<T> {
	public T e16, e17, e18, e19, e20, e21, e22, e23;

	public Array24(T e0, T e1, T e2, T e3, T e4, T e5, T e6, T e7, T e8, T e9, T e10, T e11, T e12, T e13, T e14, T e15, T e16, T e17, T e18, T e19, T e20, T e21, T e22, T e23) {
		super(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15);
		this.e16 = e16;
		this.e17 = e17;
		this.e18 = e18;
		this.e19 = e19;
		this.e20 = e20;
		this.e21 = e21;
		this.e22 = e22;
		this.e23 = e23;
		
	} public Array24() {}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toJavaArray() {
		return (T[]) new Object[]{e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16, e17, e18, e19, e20, e21, e22, e23};
	}

	@Override
	public int length() {
		return 24;
	}

	@SuppressWarnings("unchecked")
	@Override
	FTable<Array<?>, Object> table() {
		return ftable;
	}

	@SuppressWarnings({"rawtypes"})
	private static final FTable ftable = FTable.fast(MethodHandles.lookup(), Array24.class, Object.class, "e", 24);
}
