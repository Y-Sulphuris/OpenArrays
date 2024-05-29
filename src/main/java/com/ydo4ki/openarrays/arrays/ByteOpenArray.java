package com.ydo4ki.openarrays.arrays;

public abstract class ByteOpenArray extends AnyOpenArray<Byte> {

	public abstract byte get(int index);

	public abstract void set(int index, byte element);

	public abstract byte[] toJavaArray();

	@Override
	protected Byte getObject(int index) {
		return get(index);
	}

	@Override
	protected void setObject(int index, Byte value) {
		set(index, value);
	}

	@Override
	public ByteOpenArray clone() {
		return (ByteOpenArray) super.clone();
	}
}



