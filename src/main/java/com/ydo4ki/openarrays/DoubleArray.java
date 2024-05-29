package com.ydo4ki.openarrays;

public interface DoubleArray extends AnyArray<Double> {

    double get(int index);

    void set(int index, double value);
}
