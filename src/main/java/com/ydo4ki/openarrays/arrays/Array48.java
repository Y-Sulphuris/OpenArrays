package com.ydo4ki.openarrays.arrays;

import com.ydo4ki.openarrays.ftable.FTable;

import java.lang.invoke.MethodHandles;

public class Array48<T> extends Array40<T> {
	public T e40, e41, e42, e43, e44, e45, e46, e47;

	public Array48(T e0, T e1, T e2, T e3, T e4, T e5, T e6, T e7, T e8, T e9, T e10, T e11, T e12, T e13, T e14, T e15, T e16, T e17, T e18, T e19, T e20, T e21, T e22, T e23, T e24, T e25, T e26, T e27, T e28, T e29, T e30, T e31, T e32, T e33, T e34, T e35, T e36, T e37, T e38, T e39, T e40, T e41, T e42, T e43, T e44, T e45, T e46, T e47) {
		super(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16, e17, e18, e19, e20, e21, e22, e23, e24, e25, e26, e27, e28, e29, e30, e31, e32, e33, e34, e35, e36, e37, e38, e39);
		this.e40 = e40;
		this.e41 = e41;
		this.e42 = e42;
		this.e43 = e43;
		this.e44 = e44;
		this.e45 = e45;
		this.e46 = e46;
		this.e47 = e47;
		
	} public Array48() {}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toJavaArray() {
		return (T[]) new Object[]{e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16, e17, e18, e19, e20, e21, e22, e23, e24, e25, e26, e27, e28, e29, e30, e31, e32, e33, e34, e35, e36, e37, e38, e39, e40, e41, e42, e43, e44, e45, e46, e47};
	}

	@Override
	public int length() {
		return 48;
	}

	@SuppressWarnings("unchecked")
	@Override
	FTable<Array<?>, Object> table() {
		return ftable;
	}

	@SuppressWarnings({"rawtypes"})
	private static final FTable ftable = FTable.fast(MethodHandles.lookup(), Array48.class, Object.class, "e", 48);
}
