package com.ydo4ki.openarrays.arrays;

import java.util.Arrays;
import java.util.RandomAccess;

public abstract class AnyArray<T> implements java.io.Serializable, RandomAccess, Cloneable, Iterable<T> {
	public abstract int length();

	protected final void rangeCheck(int index) throws ArrayIndexOutOfBoundsException {
		if (index < 0 || index >= length()) throw clearLastStackElements(new ArrayIndexOutOfBoundsException(index), 2);
	}
	protected final void rangeCheck(int fromIndex, int toIndex) {
		if (fromIndex > toIndex) {
			throw new IllegalArgumentException(
					"fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
		}
		if (fromIndex < 0) {
			throw new ArrayIndexOutOfBoundsException(fromIndex);
		}
		if (toIndex > length()) {
			throw new ArrayIndexOutOfBoundsException(toIndex);
		}
	}

	static <T extends Throwable> T clearLastStackElements(T throwable, int count) {
		StackTraceElement[] stackTrace = throwable.getStackTrace();
		throwable.setStackTrace(Arrays.copyOfRange(stackTrace, Math.min(count, stackTrace.length), stackTrace.length));
		return throwable;
	}

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
