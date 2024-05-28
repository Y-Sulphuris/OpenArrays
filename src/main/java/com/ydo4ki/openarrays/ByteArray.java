package com.ydo4ki.openarrays;

public abstract class ByteArray extends AnyArray<Byte> {

	public abstract byte get(int index);

	public abstract void set(int index, byte element);

	public abstract byte[] toJavaArray();

	@Override
	protected Byte genericGet(int index) {
		return get(index);
	}

	@Override
	protected void genericSet(int index, Byte value) {
		set(index, value);
	}

	@Override
	public ByteArray clone() {
		return (ByteArray) super.clone();
	}
}



