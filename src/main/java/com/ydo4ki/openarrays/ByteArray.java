package com.ydo4ki.openarrays;

public interface ByteArray extends AnyArray<Byte> {

    byte get(int index);

    void set(int index, byte value);
}
