package com.ydo4ki.openarrays.arrays;

import com.ydo4ki.openarrays.ftable.FTable;

import java.lang.invoke.MethodHandles;

public class Array32<T> extends Array24<T> {
	public T e24, e25, e26, e27, e28, e29, e30, e31;

	public Array32(T e0, T e1, T e2, T e3, T e4, T e5, T e6, T e7, T e8, T e9, T e10, T e11, T e12, T e13, T e14, T e15, T e16, T e17, T e18, T e19, T e20, T e21, T e22, T e23, T e24, T e25, T e26, T e27, T e28, T e29, T e30, T e31) {
		super(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16, e17, e18, e19, e20, e21, e22, e23);
		this.e24 = e24;
		this.e25 = e25;
		this.e26 = e26;
		this.e27 = e27;
		this.e28 = e28;
		this.e29 = e29;
		this.e30 = e30;
		this.e31 = e31;
		
	} public Array32() {}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toJavaArray() {
		return (T[]) new Object[]{e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16, e17, e18, e19, e20, e21, e22, e23, e24, e25, e26, e27, e28, e29, e30, e31};
	}

	@Override
	public int length() {
		return 32;
	}

	@SuppressWarnings("unchecked")
	@Override
	FTable<Array<?>, Object> table() {
		return ftable;
	}

	@SuppressWarnings({"rawtypes"})
	private static final FTable ftable = FTable.fast(MethodHandles.lookup(), Array32.class, Object.class, "e", 32);
}
