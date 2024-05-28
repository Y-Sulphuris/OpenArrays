package com.ydo4ki.openarrays;

public abstract class CharArray extends AnyArray<Character> {

	public abstract char get(int index);

	public abstract void set(int index, char element);

	public abstract char[] toJavaArray();

	@Override
	protected Character genericGet(int index) {
		return get(index);
	}

	@Override
	protected void genericSet(int index, Character value) {
		set(index, value);
	}

	@Override
	public CharArray clone() {
		return (CharArray) super.clone();
	}

}
