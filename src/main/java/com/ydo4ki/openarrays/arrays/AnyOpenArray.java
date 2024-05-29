package com.ydo4ki.openarrays.arrays;

import com.ydo4ki.openarrays.AnyArray;

import java.util.Arrays;

public abstract class AnyOpenArray<T> implements AnyArray<T> {
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


	public static <T> T get(AnyOpenArray<T> a, int index) {
		return a.getObject(index);
	}
	public static <T> void set(AnyOpenArray<T> a, int index, T newValue) {
		a.setObject(index, newValue);
	}

	protected abstract T getObject(int index);

	protected abstract void setObject(int index, T value);

	@SuppressWarnings("unchecked")
	@Override
	public AnyOpenArray<T> clone() {
		try {
			return (AnyOpenArray<T>) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}
}
