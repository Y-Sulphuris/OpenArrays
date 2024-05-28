package com.ydo4ki.openarrays.arrays;

import com.ydo4ki.openarrays.ftable.FTable;

import java.lang.invoke.MethodHandles;

public class Array128<T> extends Array120<T> {
	public T e120, e121, e122, e123, e124, e125, e126, e127;

	public Array128(T e0, T e1, T e2, T e3, T e4, T e5, T e6, T e7, T e8, T e9, T e10, T e11, T e12, T e13, T e14, T e15, T e16, T e17, T e18, T e19, T e20, T e21, T e22, T e23, T e24, T e25, T e26, T e27, T e28, T e29, T e30, T e31, T e32, T e33, T e34, T e35, T e36, T e37, T e38, T e39, T e40, T e41, T e42, T e43, T e44, T e45, T e46, T e47, T e48, T e49, T e50, T e51, T e52, T e53, T e54, T e55, T e56, T e57, T e58, T e59, T e60, T e61, T e62, T e63, T e64, T e65, T e66, T e67, T e68, T e69, T e70, T e71, T e72, T e73, T e74, T e75, T e76, T e77, T e78, T e79, T e80, T e81, T e82, T e83, T e84, T e85, T e86, T e87, T e88, T e89, T e90, T e91, T e92, T e93, T e94, T e95, T e96, T e97, T e98, T e99, T e100, T e101, T e102, T e103, T e104, T e105, T e106, T e107, T e108, T e109, T e110, T e111, T e112, T e113, T e114, T e115, T e116, T e117, T e118, T e119, T e120, T e121, T e122, T e123, T e124, T e125, T e126, T e127) {
		super(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16, e17, e18, e19, e20, e21, e22, e23, e24, e25, e26, e27, e28, e29, e30, e31, e32, e33, e34, e35, e36, e37, e38, e39, e40, e41, e42, e43, e44, e45, e46, e47, e48, e49, e50, e51, e52, e53, e54, e55, e56, e57, e58, e59, e60, e61, e62, e63, e64, e65, e66, e67, e68, e69, e70, e71, e72, e73, e74, e75, e76, e77, e78, e79, e80, e81, e82, e83, e84, e85, e86, e87, e88, e89, e90, e91, e92, e93, e94, e95, e96, e97, e98, e99, e100, e101, e102, e103, e104, e105, e106, e107, e108, e109, e110, e111, e112, e113, e114, e115, e116, e117, e118, e119);
		this.e120 = e120;
		this.e121 = e121;
		this.e122 = e122;
		this.e123 = e123;
		this.e124 = e124;
		this.e125 = e125;
		this.e126 = e126;
		this.e127 = e127;
		
	} public Array128() {}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toJavaArray() {
		return (T[]) new Object[]{e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16, e17, e18, e19, e20, e21, e22, e23, e24, e25, e26, e27, e28, e29, e30, e31, e32, e33, e34, e35, e36, e37, e38, e39, e40, e41, e42, e43, e44, e45, e46, e47, e48, e49, e50, e51, e52, e53, e54, e55, e56, e57, e58, e59, e60, e61, e62, e63, e64, e65, e66, e67, e68, e69, e70, e71, e72, e73, e74, e75, e76, e77, e78, e79, e80, e81, e82, e83, e84, e85, e86, e87, e88, e89, e90, e91, e92, e93, e94, e95, e96, e97, e98, e99, e100, e101, e102, e103, e104, e105, e106, e107, e108, e109, e110, e111, e112, e113, e114, e115, e116, e117, e118, e119, e120, e121, e122, e123, e124, e125, e126, e127};
	}

	@Override
	public int length() {
		return 128;
	}

	@SuppressWarnings("unchecked")
	@Override
	FTable<Array<?>, Object> table() {
		return ftable;
	}

	@SuppressWarnings({"rawtypes"})
	private static final FTable ftable = FTable.fast(MethodHandles.lookup(), Array128.class, Object.class, "e", 128);
}
