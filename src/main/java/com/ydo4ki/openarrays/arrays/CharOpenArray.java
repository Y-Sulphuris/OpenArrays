package com.ydo4ki.openarrays.arrays;

public abstract class CharOpenArray extends AnyOpenArray<Character> {

	public abstract char get(int index);

	public abstract void set(int index, char element);

	public abstract char[] toJavaArray();

	@Override
	protected Character getObject(int index) {
		return get(index);
	}

	@Override
	protected void setObject(int index, Character value) {
		set(index, value);
	}

	@Override
	public CharOpenArray clone() {
		return (CharOpenArray) super.clone();
	}

}
